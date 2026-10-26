package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entities.Option;
import repository.OptionBusiness;

public class Mutations implements GraphQLRootResolver {
    public static OptionBusiness optionBusiness = new OptionBusiness();

    public Mutations(OptionBusiness opB) {
        this.optionBusiness = opB;
    }

    public Boolean ajouterOption(int codeOption, String libelle,
                             String domaine, String responsable,
                             int credits, int capacite, int semestre) {
        Option o=new Option(codeOption,libelle,domaine,responsable,credits,capacite,semestre);
      return   optionBusiness.addOption(o);
    }

    public Boolean modifierOption(int codeOption, String libelle,
                        String domaine, String responsable,
                        int credits, int capacite, int semestre) {
       Option o= new Option(codeOption,libelle,domaine,responsable,credits,capacite,semestre);
       return optionBusiness.updateOption(codeOption,o);
    }
    public String supprimerOption(int code) {
        if( optionBusiness.deleteOption(code))
            return "Supprimer Option";
        return "Erreur";
    }
}
