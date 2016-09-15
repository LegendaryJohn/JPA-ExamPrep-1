/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Project;
import entity.ProjectUser;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author kann
 */
public class Facade {
    
    EntityManagerFactory emf;
    
    public Facade(EntityManagerFactory emf){
        this.emf = emf;
    }
    
    public ProjectUser createUser(ProjectUser u){
        EntityManager em = emf.createEntityManager();
        
        try{
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
            return u;
        }
        finally{
            em.close();
        }
    }
    
    public ProjectUser getUser(int id){
        EntityManager em = emf.createEntityManager();
        
        ProjectUser u = null;
        
        try{
            em.getTransaction().begin();
            u = em.find(ProjectUser.class, id);
            em.getTransaction().commit();
            return u;
        }
        finally{
            em.close();
        }
        
    }
    
    public List<ProjectUser> getUsers(){
        EntityManager em = emf.createEntityManager();
        
        List<ProjectUser> users = null;
        
        try{
            em.getTransaction().begin();
            users = em.createQuery("Select u from ProjectUser u").getResultList();
            em.getTransaction().commit();
            return users;
        }
        finally{
            em.close();
        }
    }
    
    public Project createProject(Project p){
        EntityManager em = emf.createEntityManager();
        
        try{
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            return p;
        }
        finally{
            em.close();
        }
    }
    
    public Project getProject(int id){
        EntityManager em = emf.createEntityManager();
        
        Project p = null;
        
        try{
            em.getTransaction().begin();
            p = em.find(Project.class, id);
            em.getTransaction().commit();
            return p;
        }
        finally{
            em.close();
        }
        
    }
    
    
}
