package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entities.Option;
import repository.OptionBusiness;
import java.util.List;

public class Queries implements GraphQLRootResolver {

    public static OptionBusiness optionBusiness = new OptionBusiness();

    public Queries(OptionBusiness opB) {
        this.optionBusiness = opB;
    }

    public List<Option> gelAllOptions(){
        return optionBusiness.getListeOptions();
    }

}
