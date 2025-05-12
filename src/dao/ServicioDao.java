package dao;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import datos.Servicio;
import datos.Turno;

public class ServicioDao {
	private static Session session;
	private Transaction tx;
	private static ServicioDao instancia = null;

	protected ServicioDao() {
	}

	public static ServicioDao getInstance() {
		if (instancia == null)
			instancia = new ServicioDao();
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

	public int agregar(Servicio objeto) {
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

	public Servicio traer(long servicioId) {
		Servicio objeto = null;
		try {
			iniciaOperacion();
			objeto = (Servicio) session.createQuery("from Servicio s where s.servicioId=:servicioId")
					.setParameter("servicioId", servicioId).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	public List<Servicio> traer() throws HibernateException {
		List<Servicio> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Servicio", Servicio.class).list();
		} finally {
			session.close();
		}
		return lista;
	}

	public void eliminar(Servicio objeto) {
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

	public void actualizar(Servicio objeto) {
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

	public Servicio traerServicioYEmpleado(long servicioId) {
		Servicio objeto = null;
		try {
			iniciaOperacion();
			String hql = "FROM Servicio s inner join fetch s.empleado where s.servicioId = :servicioId";
			 objeto = (Servicio) session.createQuery(hql)
			                              .setParameter("servicioId", servicioId)
			                              .uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	public Servicio traerServicioYTurnos(long servicioId) throws HibernateException {
		Servicio objeto = null;
		try {
		iniciaOperacion();
		String hql = "from Servicio c where c.servicioId=:servicioId";
		objeto=(Servicio) session.createQuery(hql).setParameter("servicioId", servicioId).uniqueResult();
		Hibernate.initialize(objeto.getTurnos());
		} finally {
		session.close();
		} return objeto;
		}
	public Servicio traerServicioYTurnosPorFecha(long servicioId, LocalDate fecha) throws HibernateException {
	    Servicio objeto = null;
	    try {
	        iniciaOperacion();
	        String hql = "from Servicio c where c.servicioId=:servicioId";
	        objeto = (Servicio) session.createQuery(hql)
	                                .setParameter("servicioId", servicioId)
	                                .uniqueResult();
	        
	        
	        if (objeto != null && objeto.getTurnos() != null) {
	        	
	            Set<Turno> turnos = new HashSet<>();
	            for (Turno t : objeto.getTurnos()) {
	                if(t.getFecha().equals(fecha)) {
	                	turnos.add(t);
	                }
	            }
	            objeto.setTurnos(turnos);
	            
	        }
	    } finally {
	        session.close();
	    }
	    return objeto;
	}
}
