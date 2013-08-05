/*
 *    Simple Client for VIES VAT Number Validation
 * 
 *    Copyright (c) 2013 Physikalisch-Technische Bundesanstalt (PTB)
 *    Abbestr. 2-13, 10587 Berlin, Germany, http://insika.de/
 * 
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 * 
 *    http://www.apache.org/licenses/LICENSE-2.0
 * 
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 * 
 *    Information on the VAT Information Exchange System (VIES) of the EU:
 *    http://ec.europa.eu/taxation_customs/vies/vatRequest.html
 * 
 * 
 */
package checkvatid;

/**
 *
 * @author jowo
 */
public class CheckVatId {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if( args.length != 2 ) {
            System.out.println("\nCheckVatId check the validity of a VAT ID " );
            System.out.println("usage: " );
            System.out.println("for environments with direct connection to the internet type:" );
            System.out.println("java -jar CheckVatId.jar <countryCode> <vatNumber>" );
            System.out.println("\n..and replace <countryCode> and <vatNumber> by the strings to be checked, e.g.:" );
            System.out.println("java -jar CheckVatId.jar \"DE\" \"811240952\" " );
            System.out.println("\nif you are behind an enterprise proxy, you have to specify it by:" );            
            System.out.println("java -Dhttp.proxyHost=\"proxy\" -Dhttp.proxyPort=\"8080\" -jar CheckVatId.jar \"DE\" \"811240952\" " );
        } else {
            try { // Call Web Service Operation
                checkvatid.CheckVatService service = new checkvatid.CheckVatService();
                checkvatid.CheckVatPortType port = service.getCheckVatPort();

                // initialize WS operation arguments
                javax.xml.ws.Holder<java.lang.String> countryCode = new javax.xml.ws.Holder<java.lang.String>(args[0]); //(args[1]);
                javax.xml.ws.Holder<java.lang.String> vatNumber = new javax.xml.ws.Holder<java.lang.String>(args[1]); //("811240952"); 
                javax.xml.ws.Holder<javax.xml.datatype.XMLGregorianCalendar> requestDate = new javax.xml.ws.Holder<javax.xml.datatype.XMLGregorianCalendar>();
                javax.xml.ws.Holder<Boolean> valid = new javax.xml.ws.Holder<Boolean>();
                javax.xml.ws.Holder<java.lang.String> name = new javax.xml.ws.Holder<java.lang.String>();
                javax.xml.ws.Holder<java.lang.String> address = new javax.xml.ws.Holder<java.lang.String>();
                port.checkVat(countryCode, vatNumber, requestDate, valid, name, address);

                System.out.println("Request : countryCode:" + countryCode.value.toString() + " vatNumber:" + vatNumber.value.toString());        
                System.out.println("Result  : " + valid.value.toString());        
                if( valid.value ){
                    System.out.println("VALID VAT-ID");
                } else {
                    System.out.println("INVALID VAT-ID !");
                }       
                
                System.out.println("ReqDate : " + requestDate.value.toString());
                System.out.println("Name    : " + name.value.toString());
                System.out.println("Address : " + address.value.toString());

            } catch (Exception ex) {
                // TODO handle custom exceptions here
                System.out.println("Exception");
            } 
        }
    }
}
