package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entities.Etudiant;
import entities.Option;
import repository.EtudiantBusiness;
import repository.OptionBusiness;
import java.util.List;

public class Queries implements GraphQLRootResolver {

    public static OptionBusiness optionBusiness = new OptionBusiness();
    public static EtudiantBusiness etudiantBusiness = new EtudiantBusiness();
    public Queries(OptionBusiness opB, EtudiantBusiness etB) {
        this.optionBusiness = opB;
        this.etudiantBusiness = etB;
    }

    public List<Option> gelAllOptions(){
        return optionBusiness.getListeOptions();
    }
    public List<Option> getOptionsByDomaine(String domaine){
        return optionBusiness.getOptionsByDomaine(domaine);

    }
    public Etudiant geEtudiantById(String id){
        return etudiantBusiness.getEtudiantByIdentifiant(id);
    }
}
