/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Alex
 */
public class Summary {
    private SupplierDirectory supplierDirectory;
    private ProductCatalog productCatalog;
   
    
    public Summary(SupplierDirectory supplierDirectory){
       
        this.supplierDirectory = supplierDirectory;
        apple();
        Dell();
        HP();
        Toshiba();
        Lenovo();
        for(Supplier s : supplierDirectory.getSupplierDirectory()){
            System.out.println("Supplier: " + s.getSupplierName());
            for(Product p:s.getProductCatalog().getProductList()){
                System.out.println("Name: " + p.getProductName() + " " + "Price: " + p.getPrice() + " " +
                        "Availability: " + p.getAvailability() + " " + "ModleNumber: " + p.getModelNumber());
            }
            System.out.println("");
        }
    }
    
    public void apple(){
        Supplier appleSupplier = supplierDirectory.addSupplier();
        appleSupplier.setSupplierName("Apple");
        productCatalog = appleSupplier.getProductCatalog();
        
        Product apple1 =  productCatalog.addProduct();
        apple1.setProductName("Macbook");
        apple1.setPrice(1299);
        apple1.setAvailability(20);
        
        Product apple2 =  productCatalog.addProduct();
        apple2.setProductName("MacAir11");
        apple2.setPrice(799);
        apple2.setAvailability(10);
        
        Product apple3 =  productCatalog.addProduct();
        apple3.setProductName("MacAir13");
        apple3.setPrice(999);
        apple3.setAvailability(30);
        
        Product apple4 =  productCatalog.addProduct();
        apple4.setProductName("MacPro13");
        apple4.setPrice(1299);
        apple4.setAvailability(40);
        
        Product apple5 =  productCatalog.addProduct();
        apple5.setProductName("MacPro15");
        apple5.setPrice(1499);
        apple5.setAvailability(10);
        
        Product apple6 =  productCatalog.addProduct();
        apple6.setProductName("IMac15");
        apple6.setPrice(1099);
        apple6.setAvailability(13);
        
        Product apple7 =  productCatalog.addProduct();
        apple7.setProductName("IMac17");
        apple7.setPrice(1199);
        apple7.setAvailability(22);
        
        Product apple8 =  productCatalog.addProduct();
        apple8.setProductName("IMac21");
        apple8.setPrice(1599);
        apple8.setAvailability(7);
        
        Product apple9 =  productCatalog.addProduct();
        apple9.setProductName("IpadAir2");
        apple9.setPrice(599);
        apple9.setAvailability(100);
        
        Product apple10 =  productCatalog.addProduct();
        apple10.setProductName("IpadPro");
        apple10.setPrice(799);
        apple10.setAvailability(200);
        

   }
    public void Dell(){
        Supplier DellSupplier = supplierDirectory.addSupplier();
        DellSupplier.setSupplierName("Dell");
        productCatalog = DellSupplier.getProductCatalog();
        
        Product Dell1 =  productCatalog.addProduct();
        Dell1.setProductName("Inspiron11");
        Dell1.setPrice(199.99);
        Dell1.setAvailability(30);
        
        Product Dell2 =  productCatalog.addProduct();
        Dell2.setProductName("Inspiron15");
        Dell2.setPrice(249.99);
        Dell2.setAvailability(45);
        
        Product Dell3 =  productCatalog.addProduct();
        Dell3.setProductName("Alienware13");
        Dell3.setPrice(899.99);
        Dell3.setAvailability(45);
        
        Product Dell4 =  productCatalog.addProduct();
        Dell4.setProductName("Alienware15");
        Dell4.setPrice(1299.99);
        Dell4.setAvailability(60);
        
        Product Dell5 =  productCatalog.addProduct();
        Dell5.setProductName("Alienware17");
        Dell5.setPrice(1549.99);
        Dell5.setAvailability(10);
        
        Product Dell6 =  productCatalog.addProduct();
        Dell6.setProductName("Latitud15");
        Dell6.setPrice(549);
        Dell6.setAvailability(30);
        
        Product Dell7 =  productCatalog.addProduct();
        Dell7.setProductName("Venue11");
        Dell7.setPrice(349);
        Dell7.setAvailability(20);
        
        Product Dell8 =  productCatalog.addProduct();
        Dell8.setProductName("Venue13");
        Dell8.setPrice(559);
        Dell8.setAvailability(30);
        
        Product Dell9 =  productCatalog.addProduct();
        Dell9.setProductName("Venue15");
        Dell9.setPrice(299.99);
        Dell9.setAvailability(30);
        
        Product Dell10 =  productCatalog.addProduct();
        Dell10.setProductName("Inspiron");
        Dell10.setPrice(499);
        Dell10.setAvailability(31);
        
    }
    public void HP(){
        Supplier HPSupplier = supplierDirectory.addSupplier();
        HPSupplier.setSupplierName("HP");
        productCatalog = HPSupplier.getProductCatalog();
        
        Product HP1 = productCatalog.addProduct();
        HP1.setProductName("WM");
        HP1.setPrice(649);
        HP1.setAvailability(30);
        
        Product HP2 = productCatalog.addProduct();
        HP2.setProductName("Pavilion");
        HP2.setPrice(849);
        HP2.setAvailability(30);
        
        Product HP3 = productCatalog.addProduct();
        HP3.setProductName("Stream");
        HP3.setPrice(199);
        HP3.setAvailability(40);
        
        Product HP4 = productCatalog.addProduct();
        HP4.setProductName("Stream11");
        HP4.setPrice(499);
        HP4.setAvailability(30);
        
        Product HP5 = productCatalog.addProduct();
        HP5.setProductName("Stream12");
        HP5.setPrice(249);
        HP5.setAvailability(30);
        
        Product HP6 = productCatalog.addProduct();
        HP6.setProductName("Newest12");
        HP6.setPrice(329);
        HP6.setAvailability(30);
        
        Product HP7= productCatalog.addProduct();
        HP7.setProductName("Newest16");
        HP7.setPrice(334);
        HP7.setAvailability(31);
        
        Product HP8= productCatalog.addProduct();
        HP8.setProductName("Newest18");
        HP8.setPrice(329);
        HP8.setAvailability(30);
        
        Product HP9= productCatalog.addProduct();
        HP9.setProductName("Newes20t");
        HP9.setPrice(349);
        HP9.setAvailability(32);
        
        Product HP10= productCatalog.addProduct();
        HP10.setProductName("Newest11");
        HP10.setPrice(311);
        HP10.setAvailability(30);
        
    }
    public void Toshiba(){
        Supplier ToshibaSupplier = supplierDirectory.addSupplier();
        ToshibaSupplier.setSupplierName("Toshiba");
        productCatalog = ToshibaSupplier.getProductCatalog();
        
        Product Toshiba1 =  productCatalog.addProduct();
        Toshiba1.setProductName("Product1");
        Toshiba1.setPrice(199.99);
        Toshiba1.setAvailability(30);
        
        Product Toshiba2 =  productCatalog.addProduct();
        Toshiba2.setProductName("Product2");
        Toshiba2.setPrice(249.99);
        Toshiba2.setAvailability(45);
        
        Product Toshiba3 =  productCatalog.addProduct();
        Toshiba3.setProductName("Product3");
        Toshiba3.setPrice(899.99);
        Toshiba3.setAvailability(45);
        
        Product Toshiba4 =  productCatalog.addProduct();
        Toshiba4.setProductName("Product4");
        Toshiba4.setPrice(1299.99);
        Toshiba4.setAvailability(60);
        
        Product Toshiba5 =  productCatalog.addProduct();
        Toshiba5.setProductName("Product5");
        Toshiba5.setPrice(1549.99);
        Toshiba5.setAvailability(10);
        
        Product Toshiba6 =  productCatalog.addProduct();
        Toshiba6.setProductName("Product6");
        Toshiba6.setPrice(549);
        Toshiba6.setAvailability(30);
        
        Product Toshiba7 =  productCatalog.addProduct();
        Toshiba7.setProductName("Product7");
        Toshiba7.setPrice(349);
        Toshiba7.setAvailability(20);
        
        Product Toshiba8 =  productCatalog.addProduct();
        Toshiba8.setProductName("Product8");
        Toshiba8.setPrice(199.99);
        Toshiba8.setAvailability(30);
        
        Product Toshiba9 =  productCatalog.addProduct();
        Toshiba9.setProductName("Product9");
        Toshiba9.setPrice(199.99);
        Toshiba9.setAvailability(30);
        
        Product Toshiba10 =  productCatalog.addProduct();
        Toshiba10.setProductName("Product10");
        Toshiba10.setPrice(199.99);
        Toshiba10.setAvailability(30);
        
    }
    public void Lenovo(){
        Supplier DellSupplier = supplierDirectory.addSupplier();
        DellSupplier.setSupplierName("Lenovo");
        productCatalog = DellSupplier.getProductCatalog();
        
        Product Lenovo1 =  productCatalog.addProduct();
        Lenovo1.setProductName("Product1");
        Lenovo1.setPrice(199.99);
        Lenovo1.setAvailability(30);
        
        Product Lenovo2 =  productCatalog.addProduct();
        Lenovo2.setProductName("Product2");
        Lenovo2.setPrice(249.99);
        Lenovo2.setAvailability(45);
        
        Product Lenovo3 =  productCatalog.addProduct();
        Lenovo3.setProductName("Product3");
        Lenovo3.setPrice(899.99);
        Lenovo3.setAvailability(45);
        
        Product Lenovo4 =  productCatalog.addProduct();
        Lenovo4.setProductName("Product4");
        Lenovo4.setPrice(1299.99);
        Lenovo4.setAvailability(60);
        
        Product Lenovo5 =  productCatalog.addProduct();
        Lenovo5.setProductName("Product5");
        Lenovo5.setPrice(1549.99);
        Lenovo5.setAvailability(10);
        
        Product Lenovo6 =  productCatalog.addProduct();
        Lenovo6.setProductName("Product6");
        Lenovo6.setPrice(549);
        Lenovo6.setAvailability(30);
        
        Product Lenovo7 =  productCatalog.addProduct();
        Lenovo7.setProductName("Product7");
        Lenovo7.setPrice(349);
        Lenovo7.setAvailability(20);
        
        Product Lenovo8 =  productCatalog.addProduct();
        Lenovo8.setProductName("Product8");
        Lenovo8.setPrice(199.99);
        Lenovo8.setAvailability(30);
        
        Product Lenovo9 =  productCatalog.addProduct();
        Lenovo9.setProductName("Product9");
        Lenovo9.setPrice(199.99);
        Lenovo9.setAvailability(30);
        
        Product Lenovo10 =  productCatalog.addProduct();
        Lenovo10.setProductName("Product10");
        Lenovo10.setPrice(199.99);
        Lenovo10.setAvailability(30);
    }
            
}
