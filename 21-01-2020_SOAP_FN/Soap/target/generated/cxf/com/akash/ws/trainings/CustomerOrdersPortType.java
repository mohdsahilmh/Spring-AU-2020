package com.akash.ws.trainings;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.2.1
 * 2020-01-27T12:10:46.258+05:30
 * Generated source version: 3.2.1
 * 
 */
@WebService(targetNamespace = "http://trainings.ws.akash.com/", name = "CustomerOrdersPortType")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface CustomerOrdersPortType {

    @WebMethod
    @WebResult(name = "getOrdersResponse", targetNamespace = "http://trainings.ws.akash.com/", partName = "parameters")
    public GetOrdersResponse getOrders(
        @WebParam(partName = "parameters", name = "getOrdersRequest", targetNamespace = "http://trainings.ws.akash.com/")
        GetOrdersRequest parameters
    );

    @WebMethod
    @WebResult(name = "createOrdersResponse", targetNamespace = "http://trainings.ws.akash.com/", partName = "parameters")
    public CreateOrdersResponse createOrders(
        @WebParam(partName = "parameters", name = "createOrdersRequest", targetNamespace = "http://trainings.ws.akash.com/")
        CreateOrdersRequest parameters
    );

    @WebMethod
    @WebResult(name = "deleteOrdersResponse", targetNamespace = "http://trainings.ws.akash.com/", partName = "parameters")
    public DeleteOrdersResponse deleteOrders(
        @WebParam(partName = "parameters", name = "deleteOrdersRequest", targetNamespace = "http://trainings.ws.akash.com/")
        DeleteOrdersRequest parameters
    );

    @WebMethod
    @WebResult(name = "updateOrdersResponse", targetNamespace = "http://trainings.ws.akash.com/", partName = "parameters")
    public UpdateOrdersResponse updateOrders(
        @WebParam(partName = "parameters", name = "updateOrdersRequest", targetNamespace = "http://trainings.ws.akash.com/")
        UpdateOrdersRequest parameters
    );
}
