package fr.efficom.jee.crudTo.Service;

import fr.efficom.jee.crudTo.Entity.UserEntity;
import fr.efficom.jee.crudTo.Repository.UserRepository;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;
import java.io.*;
import java.util.List;

@ManagedBean
@RequestScoped
public class ManagedUserBean implements Serializable {

    @Inject
    private UserService userService;
    @Inject
    private UserRepository userRepository;

    private Part file;
    private UserEntity userEntity = new UserEntity();

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public UserEntity connect() {
        return userService.isConnectValid(userEntity);
    }

    public UserEntity createorUpdateUser() {
        return userRepository.createorUpdateUser(userEntity);
    }

    public UserEntity findUserByID() {
        return userRepository.findUserByID(userEntity.getIdUser());
    }

    public List<UserEntity> findUserByName() {
        return userRepository.findUserByName(userEntity.getUserName());
    }

    public static String getFileNameFromPart(Part part) throws Exception {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : partHeader.split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        throw new Exception("Erreur sur le noms du fichier");
    }

    public void uploadFile() throws Exception {
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String path = servletContext.getRealPath("");
        boolean fileSuccess = false;
        String fileName = "";
        if (file != null && file.getSize() > 0) {
            fileName = getFileNameFromPart(file);

            File outputFile = new File(path + File.separator + "resources/avatar/" + File.separator + fileName);
            InputStream inputStream = file.getInputStream();
            OutputStream outputStream = new FileOutputStream(outputFile);
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.close();
            inputStream.close();
            fileSuccess = true;
        }

        if (fileSuccess && StringUtils.isNotEmpty(fileName)) {
            System.out.println("File uploaded to : " + path);
            userEntity.setAvatarpath(fileName);
            createorUpdateUser();

        } else {
            throw new Exception("selectionné un fiochier valide");
        }
    }
}
