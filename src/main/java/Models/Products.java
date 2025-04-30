package Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Products {
    private long productId;
    private String productName;
    private String productDescription;
    private String productImagePath;
    private Categories productCategory;

//    private String productSpecification;
//    private Integer productPrice;
//    private Integer productQuantity;

}


