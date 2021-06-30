package fr.efficom.jee.crudTo.Service;

import fr.efficom.jee.crudTo.Repository.CommentRepository;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class CommentService {

    @Inject
    private CommentRepository commentRepository;

}
