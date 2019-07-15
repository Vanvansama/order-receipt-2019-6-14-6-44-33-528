package org.katas.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        output.append(String.format("======Printing Orders======\n %s %s",order.getCustomerName(),order.getCustomerAddress()));

        // prints lineItems
        double totalSaleTax = 0d;
        double totalAmount = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            output.append(String.format("%s\t%s\t%s\t%s\n",lineItem.getDescription(),lineItem.getPrice(),lineItem.getQuantity(),lineItem.totalAmount()));
            totalSaleTax += lineItem.totalAmount() * 0.10;
            totalAmount += lineItem.totalAmount() * 1.10;
        }

        output.append(String.format("Sales Tax\t%sTotal Amount\t%s",totalSaleTax,totalAmount));
        return output.toString();
    }
}