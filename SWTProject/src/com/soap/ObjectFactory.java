
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

    private final static QName _GetAllPatientDetails_QNAME = new QName("http://soap.com/", "getAllPatientDetails");
    private final static QName _PatientDetails_QNAME = new QName("http://soap.com/", "patientDetails");
    private final static QName _GetAllPatientDetailsResponse_QNAME = new QName("http://soap.com/", "getAllPatientDetailsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PatientDetails }
     * 
     */
    public PatientDetails createPatientDetails() {
        return new PatientDetails();
    }

    /**
     * Create an instance of {@link GetAllPatientDetailsResponse }
     * 
     */
    public GetAllPatientDetailsResponse createGetAllPatientDetailsResponse() {
        return new GetAllPatientDetailsResponse();
    }

    /**
     * Create an instance of {@link GetAllPatientDetails }
     * 
     */
    public GetAllPatientDetails createGetAllPatientDetails() {
        return new GetAllPatientDetails();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllPatientDetails }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.com/", name = "getAllPatientDetails")
    public JAXBElement<GetAllPatientDetails> createGetAllPatientDetails(GetAllPatientDetails value) {
        return new JAXBElement<GetAllPatientDetails>(_GetAllPatientDetails_QNAME, GetAllPatientDetails.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PatientDetails }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.com/", name = "patientDetails")
    public JAXBElement<PatientDetails> createPatientDetails(PatientDetails value) {
        return new JAXBElement<PatientDetails>(_PatientDetails_QNAME, PatientDetails.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllPatientDetailsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.com/", name = "getAllPatientDetailsResponse")
    public JAXBElement<GetAllPatientDetailsResponse> createGetAllPatientDetailsResponse(GetAllPatientDetailsResponse value) {
        return new JAXBElement<GetAllPatientDetailsResponse>(_GetAllPatientDetailsResponse_QNAME, GetAllPatientDetailsResponse.class, null, value);
    }

}
