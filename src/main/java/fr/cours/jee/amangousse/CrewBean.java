package fr.cours.jee.amangousse;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import java.util.List;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class CrewBean {

    @Inject
    private CrewMemberDao crewMemberDao;

    public List<CrewMember> getCrewMembers() {
        return crewMemberDao.getCrewMembers();
    }

    public boolean addMember(CrewMember crewMember) {
        return crewMemberDao.addCrewMember(crewMember);
    }

    public void deleteMember(String name) {
        crewMemberDao.deleteCrewMember(name);
    }
}
