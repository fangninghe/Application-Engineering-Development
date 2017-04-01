/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 * NUID:001664202
 *
 * @author Fangning He
 */
public class Initialization {

    public static Business Initialization() {
        Business business = Business.getInstance();
        CustomerDirectory customerDirectory = business.getCustomerDirectory();
        ProductCatalog productCatalog = business.getProductCatalog();
        SaleDirectory saleDirectory = business.getSaleDirectory();
        PersonDirectory personDirectory = business.getPersonDirectory();
        
        Person p = personDirectory.addPerson();
        p.setUsername("a");
        p.setCode("a");
        p.setRole(Person.ADMIN_ROLE);

        Product pro1 = productCatalog.addProduct();
        pro1.setProductName("iPhone Gold");
        pro1.setProductDescription("Good Looking");
        pro1.setFloorPrice(599);
        pro1.setTargetPrice(799);
        pro1.setCeilingPrice(899);
        pro1.setProductFrom("China");
        pro1.setAvailablity(100);

        Product pro2 = productCatalog.addProduct();
        pro2.setProductName("iPhone White");
        pro2.setProductDescription("Good Looking");
        pro2.setFloorPrice(599);
        pro2.setTargetPrice(799);
        pro2.setCeilingPrice(899);
        pro2.setProductFrom("China");
        pro2.setAvailablity(100);

        Product pro3 = productCatalog.addProduct();
        pro3.setProductName("iPhone Gray");
        pro3.setProductDescription("Good Looking");
        pro3.setFloorPrice(599);
        pro3.setTargetPrice(799);
        pro3.setCeilingPrice(899);
        pro3.setProductFrom("China");
        pro3.setAvailablity(100);

        Product pro4 = productCatalog.addProduct();
        pro4.setProductName("iPhone Silver");
        pro4.setProductDescription("Good Looking");
        pro4.setFloorPrice(599);
        pro4.setTargetPrice(799);
        pro4.setCeilingPrice(899);
        pro4.setProductFrom("China");
        pro4.setAvailablity(100);

        Product pro5 = productCatalog.addProduct();
        pro5.setProductName("Surface Black");
        pro5.setProductDescription("Versatile");
        pro5.setFloorPrice(549);
        pro5.setTargetPrice(650);
        pro5.setCeilingPrice(799);
        pro5.setProductFrom("India");
        pro5.setAvailablity(100);

        Product pro6 = productCatalog.addProduct();
        pro6.setProductName("Surface Purple");
        pro6.setProductDescription("Versatile");
        pro6.setFloorPrice(549);
        pro6.setTargetPrice(650);
        pro6.setCeilingPrice(799);
        pro6.setProductFrom("India");
        pro6.setAvailablity(100);

        Product pro7 = productCatalog.addProduct();
        pro7.setProductName("Surface White");
        pro7.setProductDescription("Versatile");
        pro7.setFloorPrice(549);
        pro7.setTargetPrice(650);
        pro7.setCeilingPrice(799);
        pro7.setProductFrom("India");
        pro7.setAvailablity(100);

        Product pro8 = productCatalog.addProduct();
        pro8.setProductName("Laptop Silver");
        pro8.setProductDescription("Versatile");
        pro8.setFloorPrice(999);
        pro8.setTargetPrice(1100);
        pro8.setCeilingPrice(1300);
        pro8.setProductFrom("India");
        pro8.setAvailablity(100);

        Product pro9 = productCatalog.addProduct();
        pro9.setProductName("Laptop Black");
        pro9.setProductDescription("Ecnomic");
        pro9.setFloorPrice(628);
        pro9.setTargetPrice(820);
        pro9.setCeilingPrice(1000);
        pro9.setProductFrom("USA");
        pro9.setAvailablity(100);

        Product pro10 = productCatalog.addProduct();
        pro10.setProductName("Laptop Alienware");
        pro10.setProductDescription("Alienware");
        pro10.setFloorPrice(1199);
        pro10.setTargetPrice(1399);
        pro10.setCeilingPrice(1599);
        pro10.setProductFrom("USA");
        pro10.setAvailablity(100);

        Product pro11 = productCatalog.addProduct();
        pro11.setProductName("Shampoo Head&Shoulder");
        pro11.setProductDescription("Ecnomic");
        pro11.setFloorPrice(5.6);
        pro11.setTargetPrice(8.7);
        pro11.setCeilingPrice(10);
        pro11.setProductFrom("USA");
        pro11.setAvailablity(100);

        Product pro12 = productCatalog.addProduct();
        pro12.setProductName("Toner Clinique");
        pro12.setProductDescription("Number 2");
        pro12.setFloorPrice(22);
        pro12.setTargetPrice(25);
        pro12.setCeilingPrice(32);
        pro12.setProductFrom("USA");
        pro12.setAvailablity(100);

        Product pro13 = productCatalog.addProduct();
        pro13.setProductName("EyeCare Kiehl`s");
        pro13.setProductDescription("Moisture");
        pro13.setFloorPrice(24);
        pro13.setTargetPrice(30);
        pro13.setCeilingPrice(34);
        pro13.setProductFrom("USA");
        pro13.setAvailablity(100);

        Product pro14 = productCatalog.addProduct();
        pro14.setProductName("BB Kiehl`s");
        pro14.setProductDescription("Cover Flaws");
        pro14.setFloorPrice(30);
        pro14.setTargetPrice(44);
        pro14.setCeilingPrice(56);
        pro14.setProductFrom("USA");
        pro14.setAvailablity(100);

        Product pro15 = productCatalog.addProduct();
        pro15.setProductName("NightRepair EsteeLauder");
        pro15.setProductDescription("Young");
        pro15.setFloorPrice(90);
        pro15.setTargetPrice(110);
        pro15.setCeilingPrice(130);
        pro15.setProductFrom("USA");
        pro15.setAvailablity(100);

        Product pro16 = productCatalog.addProduct();
        pro16.setProductName("FaceMask Fresh");
        pro16.setProductDescription("Black tea");
        pro16.setFloorPrice(80);
        pro16.setTargetPrice(92);
        pro16.setCeilingPrice(120);
        pro16.setProductFrom("USA");
        pro16.setAvailablity(100);

        Product pro17 = productCatalog.addProduct();
        pro17.setProductName("HeathCare Centrum");
        pro17.setProductDescription("MutiVitamin");
        pro17.setFloorPrice(15);
        pro17.setTargetPrice(22);
        pro17.setCeilingPrice(30);
        pro17.setProductFrom("USA");
        pro17.setAvailablity(100);

        Product pro18 = productCatalog.addProduct();
        pro18.setProductName("HeathCare GNC");
        pro18.setProductDescription("GrapeSeed");
        pro18.setFloorPrice(13.4);
        pro18.setTargetPrice(22.9);
        pro18.setCeilingPrice(30);
        pro18.setProductFrom("USA");
        pro18.setAvailablity(100);

        Product pro19 = productCatalog.addProduct();
        pro19.setProductName("E-TeethBrush Oral-B");
        pro19.setProductDescription("3D");
        pro19.setFloorPrice(34);
        pro19.setTargetPrice(45);
        pro19.setCeilingPrice(55);
        pro19.setProductFrom("USA");
        pro19.setAvailablity(100);

        Product pro20 = productCatalog.addProduct();
        pro20.setProductName("Green Tea");
        pro20.setProductDescription("Chinses Style");
        pro20.setFloorPrice(60);
        pro20.setTargetPrice(80);
        pro20.setCeilingPrice(100);
        pro20.setProductFrom("China");
        pro20.setAvailablity(100);

        Person p1 = personDirectory.addPerson();
        Sale s1 = saleDirectory.addSale();
        s1.setName("Amily");
        s1.setID("001");
        s1.setPhone("1234567");
        s1.setAddress("111 One Street");
        p1.setUsername("1");
        p1.setCode("1");
        p1.setRole(Person.SALE_ROLE);
        p1.setPerson(s1);

        Person p2 = personDirectory.addPerson();
        Sale s2 = saleDirectory.addSale();
        s2.setName("Bob");
        s2.setID("002");
        s2.setPhone("2345678");
        s2.setAddress("222 two Street");
        p2.setUsername("2");
        p2.setCode("2");
        p2.setRole(Person.SALE_ROLE);
        p2.setPerson(s2);

        Person p3 = personDirectory.addPerson();
        Sale s3 = saleDirectory.addSale();
        s3.setName("Cindy");
        s3.setID("003");
        s3.setPhone("3456789");
        s3.setAddress("333 three Street");
        p3.setUsername("3");
        p3.setCode("3");
        p3.setRole(Person.SALE_ROLE);
        p3.setPerson(s3);

        Person p4 = personDirectory.addPerson();
        Sale s4 = saleDirectory.addSale();
        s4.setName("David");
        s4.setID("004");
        s4.setPhone("4567890");
        s4.setAddress("444 For Street");
        p4.setUsername("4");
        p4.setCode("4");
        p4.setRole(Person.SALE_ROLE);
        p4.setPerson(s4);
        
        Person p5 = personDirectory.addPerson();
        Sale s5 = saleDirectory.addSale();
        s5.setName("Freya");
        s5.setID("005");
        s5.setPhone("56778901");
        s5.setAddress("fff One Street");
        p5.setUsername("5");
        p5.setCode("5");
        p5.setRole(Person.SALE_ROLE);
        p5.setPerson(s5);

        Person p6 = personDirectory.addPerson();
        Sale s6 = saleDirectory.addSale();
        s6.setName("Emma");
        s6.setID("006");
        s6.setPhone("67789012");
        s6.setAddress("666 Six Street");
        p6.setUsername("6");
        p6.setCode("6");
        p6.setRole(Person.SALE_ROLE);
        p6.setPerson(s6);

        Person p7 = personDirectory.addPerson();
        Customer c1 = customerDirectory.addCustomer();
        c1.setName("Amanda");
        c1.setID("0001");
        c1.setPhone("123456");
        p7.setUsername("11");
        p7.setCode("11");
        p7.setRole(Person.CUSTOMER_ROLE);
        p7.setPerson(c1);

        Person p8 = personDirectory.addPerson();
        Customer c2 = customerDirectory.addCustomer();
        c2.setName("Bette");
        c2.setID("0002");
        c2.setPhone("234567");
        p8.setUsername("22");
        p8.setCode("22");
        p8.setRole(Person.CUSTOMER_ROLE);
        p8.setPerson(c2);
        

        Person p9 = personDirectory.addPerson();
        Customer c3 = customerDirectory.addCustomer();
        c3.setName("Cat");
        c3.setID("0003");
        c3.setPhone("345678");
        p9.setUsername("33");
        p9.setCode("33");
        p9.setRole(Person.CUSTOMER_ROLE);
        p9.setPerson(c3);

        Person p10 = personDirectory.addPerson();
        Customer c4 = customerDirectory.addCustomer();
        c4.setName("Dana");
        c4.setID("0004");
        c4.setPhone("456789");
        p10.setUsername("44");
        p10.setCode("44");
        p10.setRole(Person.CUSTOMER_ROLE);
        p10.setPerson(c4);

        Person p11 = personDirectory.addPerson();
        Customer c5 = customerDirectory.addCustomer();
        c5.setName("Fed");
        c5.setID("0005");
        c5.setPhone("567890");
        p11.setUsername("55");
        p11.setCode("55");
        p11.setRole(Person.CUSTOMER_ROLE);
        p11.setPerson(c5);

        return business;
    }

}
