
## Check VAT ID ##

Check the Validity of a VAT ID

This is a first draft of client to check the Value Added Tax Identification 
(VAT) of companies/organisations in the European Union. It connects to the VAT 
Information Exchange System (VIES) of the EU using a SOAP web service. Please 
find more information on VIES at:
http://ec.europa.eu/taxation_customs/vies/vatRequest.html


### Preparation ###

To get started, make shure Java has been installed correctly on your plaform. 
Open a terminal and type:
    java -version
You should see something like:
    java version "1.7.0_25" 
    ...
Otherwise install a Java Runtime Environment (JRE) on your platform.

Change to your workspace directory. Download the ZIP achive or clone this 
repository: 
    git clone http://github.com/insika/CheckVatId

Open the project using NetBeans IDE or the IDE of your choice. 
Build the project. 


### Usage ###

Change to the `/dist` subdirectory `cd CheckVatId/dist` .

In environments with direct connection to the internet type:
    java -jar CheckVatId.jar <countryCode> <vatNumber>

..and replace <countryCode> and <vatNumber> by the strings to be checked, e.g.:
    java -jar CheckVatId.jar "DE" "811240952" 

If you are behind an enterprise proxy, you have to specify it by:
    java -Dhttp.proxyHost="proxy" -Dhttp.proxyPort="8080" -jar CheckVatId.jar "DE" "811240952"


### License ###

CheckVatId is licensed under the Apache License, Version 2.0. See "LICENSE" for 
details.
