package fr.efficom.jee.crudTo.properties;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class PropertieResolver {

  @Inject
  @ConfigProperty(name = "dico")
  private String message;

  public String getMessage() {
    return this.message;
  }
}
