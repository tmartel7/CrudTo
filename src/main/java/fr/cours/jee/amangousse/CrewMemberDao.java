package fr.cours.jee.amangousse;


import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CrewMemberDao {

    @Resource
    UserTransaction userTransaction;
    @PersistenceContext
    private EntityManager entityManager;

    public List<CrewMember> getCrewMembers() {
        return entityManager.createQuery("select cm from CrewMember cm", CrewMember.class).getResultList();
    }

    public boolean addCrewMember(CrewMember crewMember) {
        try {
            userTransaction.begin();
            entityManager.persist(crewMember);
            userTransaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getGlobal().log(Level.SEVERE, "JPA error" + e.getMessage());
            return false;
        }
    }

    public boolean deleteCrewMember(String name) {
        try {
            userTransaction.begin();
            var cm = entityManager.createQuery("select cm from CrewMember cm where cm.name = :name", CrewMember.class)
                    .setParameter("name", name)
                    .getSingleResult();
            if (cm != null) {
                entityManager.remove(cm);
            }
            userTransaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getGlobal().log(Level.SEVERE, "JPA error" + e.getMessage());
            return false;
        }
    }
}
