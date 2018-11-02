
package com.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _BookAppointmentResponse_QNAME = new QName("http://soap.com/", "bookAppointmentResponse");
    private final static QName _BookAppointment_QNAME = new QName("http://soap.com/", "bookAppointment");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BookAppointmentResponse }
     * 
     */
    public BookAppointmentResponse createBookAppointmentResponse() {
        return new BookAppointmentResponse();
    }

    /**
     * Create an instance of {@link BookAppointment }
     * 
     */
    public BookAppointment createBookAppointment() {
        return new BookAppointment();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookAppointmentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.com/", name = "bookAppointmentResponse")
    public JAXBElement<BookAppointmentResponse> createBookAppointmentResponse(BookAppointmentResponse value) {
        return new JAXBElement<BookAppointmentResponse>(_BookAppointmentResponse_QNAME, BookAppointmentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookAppointment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.com/", name = "bookAppointment")
    public JAXBElement<BookAppointment> createBookAppointment(BookAppointment value) {
        return new JAXBElement<BookAppointment>(_BookAppointment_QNAME, BookAppointment.class, null, value);
    }

}
