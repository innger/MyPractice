package com.ryl.learn.webservice;


//import com.jasperwireless.api.ws.schema.*;
import com.sun.xml.wss.XWSSecurityException;

import java.io.FileNotFoundException;

public class WsdlService {

    //public static void main(String[] args) throws XWSSecurityException, FileNotFoundException {
    //
    //    String licenseKey = "6247e65f-3f4f-4b68-beab-2f2547edf8cb";
    //    String iccid = "8986061501000308529";
    //    String version = "1.0";
    //    String messageId = "message-1";
    //
    //    TerminalService service = new TerminalService();
    //    HeaderHandlerResolver resolver = new HeaderHandlerResolver();
    //    service.setHandlerResolver(resolver);
    //    TerminalPortType portType = service.getTerminalPort();
    //
    //    GetTerminalDetailsRequest request = new GetTerminalDetailsRequest();
    //    request.setLicenseKey(licenseKey);
    //    request.setVersion(version);
    //    request.setMessageId(messageId);
    //    GetTerminalDetailsRequest.Iccids iccids = new GetTerminalDetailsRequest.Iccids();
    //    iccids.getIccid().add(iccid);
    //    request.setIccids(iccids);
    //
    //    GetTerminalDetailsResponse response = portType.getTerminalDetails(request);
    //
    //
    //    System.out.println(response.getTerminals().getTerminal().get(0).getStatus());
    //
    //    EditTerminalRequest editRequest = new EditTerminalRequest();
    //    editRequest.setLicenseKey(licenseKey);
    //    editRequest.setVersion(version);
    //    editRequest.setMessageId(messageId);
    //    editRequest.setChangeType(3);
    //    editRequest.setIccid(iccid);
    //    editRequest.setTargetValue("ACTIVATED_NAME");
    //
    //    portType.editTerminal(editRequest);
    //
    //    System.out.println("finish.");
    //}
}
