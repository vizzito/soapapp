//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2016.07.22 a las 11:37:39 PM ART 
//


package soap.com.app.producing_web_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="saleOrder" type="{http://com.soap/app/producing-web-service}saleOrder"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "saleOrder"
})
@XmlRootElement(name = "addSaleOrderRequest")
public class AddSaleOrderRequest {

    @XmlElement(required = true)
    protected SaleOrder saleOrder;

    /**
     * Obtiene el valor de la propiedad saleOrder.
     * 
     * @return
     *     possible object is
     *     {@link SaleOrder }
     *     
     */
    public SaleOrder getSaleOrder() {
        return saleOrder;
    }

    /**
     * Define el valor de la propiedad saleOrder.
     * 
     * @param value
     *     allowed object is
     *     {@link SaleOrder }
     *     
     */
    public void setSaleOrder(SaleOrder value) {
        this.saleOrder = value;
    }

}
