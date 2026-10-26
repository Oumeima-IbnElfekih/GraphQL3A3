package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entities.Etudiant;
import entities.Option;
import repository.EtudiantBusiness;
import repository.OptionBusiness;

public class Mutations implements GraphQLRootResolver {
    public static OptionBusiness optionBusiness = new OptionBusiness();
    public static EtudiantBusiness etudiantBusiness = new EtudiantBusiness();
    public Mutations(OptionBusiness opB, EtudiantBusiness etB) {

        this.optionBusiness = opB;
        this.etudiantBusiness = etB;
    }

    public Boolean ajouterOption(int codeOption, String libelle,
                             String domaine, String responsable,
                             int credits, int capacite, int semestre) {
        Option o=new Option(codeOption,libelle,domaine,responsable,credits,capacite,semestre);
      return   optionBusiness.addOption(o);
    }

    public Option modifierOption(int codeOption, String libelle,
                        String domaine, String responsable,
                        int credits, int capacite, int semestre) {
       Option o= new Option(codeOption,libelle,domaine,responsable,credits,capacite,semestre);
       if( optionBusiness.updateOption(codeOption,o))
           return o;
       return null;
    }
    public String supprimerOption(int code) {
        if( optionBusiness.deleteOption(code))
            return "Supprimer Option";
        return "Erreur";
    }
    public String supprimerEtudiant(String id){
        if(etudiantBusiness.deleteEtudiant(id))
            return "Supprimer Etudiant";
        return "Erreur";
    }
    public Boolean modifierEtudiant( String id,String nom,String prenom, int codeOption,int anneEtude, String email ) {
        Option option = optionBusiness.getOptionByCode(codeOption);
        Etudiant e= new Etudiant(id,nom,prenom,option,anneEtude,email);
        return etudiantBusiness.updateEtudiant(id,e);
    }
}
