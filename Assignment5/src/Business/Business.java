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
public class Business {

    private static Business business;

    private ProductCatalog productCatalog;
    private SaleDirectory saleDirectory;
    private CustomerDirectory customerDirectory;
    private OrderCatalog orderCatalog;
    private PersonDirectory personDirectory;

    private Business() {
        saleDirectory = new SaleDirectory();
        productCatalog = new ProductCatalog();
        customerDirectory = new CustomerDirectory();
        orderCatalog = new OrderCatalog();
        personDirectory = new PersonDirectory();

    }

    public static Business getInstance() {
        if (business == null) {
            return new Business();
        }
        return business;
    }

    public ProductCatalog getProductCatalog() {
        return productCatalog;
    }

    public void setProductCatalog(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
    }

    public SaleDirectory getSaleDirectory() {
        return saleDirectory;
    }

    public void setSaleDirectory(SaleDirectory saleDirectory) {
        this.saleDirectory = saleDirectory;
    }

    public CustomerDirectory getCustomerDirectory() {
        return customerDirectory;
    }

    public void setCustomerDirectory(CustomerDirectory customerDirectory) {
        this.customerDirectory = customerDirectory;
    }

    public OrderCatalog getOrderCatalog() {
        return orderCatalog;
    }

    public void setOrderCatalog(OrderCatalog orderCatalog) {
        this.orderCatalog = orderCatalog;
    }

    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }

    public void setPersonDirectory(PersonDirectory personDirectory) {
        this.personDirectory = personDirectory;
    }

}
