package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Turno;
import datos.Usuario;

public class TurnoDao {
	private static Session session;
	private Transaction tx;
	private static TurnoDao instancia = null;

	protected TurnoDao() {
	}

	public static TurnoDao getInstance() {
		if (instancia == null)
			instancia = new TurnoDao();
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

	//
	public Turno traer(long turnoId) {
		Turno obj = null;
		try {
			iniciaOperacion();
			String hQL = "from Turno t inner join fetch t.usuario u where u.turnoId=:turnoId";
			obj = (Turno) session.createQuery(hQL).setParameter("turnoId", turnoId).uniqueResult();
		} finally {
			session.close();
		}
		return obj;
	}

	public List<Turno> traer(Usuario u) {
		List<Turno> lista = null;
		try {
			iniciaOperacion();
			String hQL = "from Turno t inner join fetch t.usuario u where u.personaId=:personaId";
			lista = session.createQuery(hQL, Turno.class).setParameter("personaId", u.getPersonaId()).getResultList();
		} finally {
			session.close();
		}
		return lista;
	}

	public int agregar(Turno objeto) {
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

	public void actualizar(Turno objeto) {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
}
