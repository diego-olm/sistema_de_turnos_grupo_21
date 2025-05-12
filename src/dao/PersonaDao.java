package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Persona;
import datos.Usuario;

public class PersonaDao {

	private static Session session;
	private Transaction tx;
	private static PersonaDao instancia = null; // Patrón Singleton

	protected PersonaDao() {
	}

	public static PersonaDao getInstance() {
		if (instancia == null)
			instancia = new PersonaDao();
		return instancia;
	}

	protected void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	protected void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	public int agregar(Persona objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}

	public Persona traer(long personaId) {
		Persona objeto = null;
		try {
			iniciaOperacion();
			objeto = (Persona) session.createQuery("from Persona p where p.personaId=:personaId")
					.setParameter("personaId", personaId).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	public Persona traerEmail(String email) {
		Persona objeto = null;
		try {
			iniciaOperacion();
			objeto = (Persona) session.createQuery("from Persona p where p.email=:email").setParameter("email", email)
					.uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	public List<Persona> traer() throws HibernateException {
		List<Persona> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Persona", Persona.class).list();
		} finally {
			session.close();
		}
		return lista;
	}

	public void eliminar(Persona objeto) {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
	}

	public void actualizar(Persona objeto) {
		try {
			iniciaOperacion();
			session.saveOrUpdate(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
	}

	public Persona traerUsuarioYTurnos(long personaId) throws HibernateException {
		Usuario objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Persona p where p.personaId=:personaId";
			objeto = (Usuario) session.createQuery(hql).setParameter("personaId", personaId).uniqueResult();
			Hibernate.initialize(objeto.getTurnos());
		} finally {
			session.close();
		}
		return objeto;
	}

}
