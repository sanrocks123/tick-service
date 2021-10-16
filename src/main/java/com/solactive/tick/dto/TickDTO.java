package com.solactive.tick.dto;

/**
 * Java Source TickDTO.java created on Oct 16, 2021
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

public class TickDTO {

    String timeStamp;
    String price;
    String closePrice;
    String currency;
    String ricCode;

    /**
     * @return the closePrice
     */
    public String getClosePrice() {
        return closePrice;
    }

    /**
     * @return the currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @return the ricCode
     */
    public String getRicCode() {
        return ricCode;
    }

    /**
     * @return the timeStamp
     */
    public String getTimeStamp() {
        return timeStamp;
    }

    /**
     * @param closePrice
     *            the closePrice to set
     */
    public void setClosePrice(String closePrice) {
        this.closePrice = closePrice;
    }

    /**
     * @param currency
     *            the currency to set
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * @param price
     *            the price to set
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * @param ricCode
     *            the ricCode to set
     */
    public void setRicCode(String ricCode) {
        this.ricCode = ricCode;
    }

    /**
     * @param timeStamp
     *            the timeStamp to set
     */
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TickDTO [timeStamp=" + timeStamp + ", price=" + price + ", closePrice=" + closePrice + ", currency="
                + currency + ", ricCode=" + ricCode + "]";
    }

}
