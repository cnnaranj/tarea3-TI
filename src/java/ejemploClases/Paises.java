/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploClases;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;
import net.webservicex.Airport;
import net.webservicex.AirportSoap;

/**
 *
 * @author Usuario
 */
@WebService(serviceName = "Paises")
public class Paises {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "ObtenerCiudades")
    public String[] obtenerCiudades(@WebParam(name = "pais") String pais) {
        //Se crea cliente para servicio global weather
        String[] result= new String[2];
        GlobalWeather gw = new GlobalWeather();
        
        //Se  obtiene cliente soap
        GlobalWeatherSoap gwsoap = gw.getGlobalWeatherSoap();
        
        //se llama al servicio
        String cities = gwsoap.getCitiesByCountry(pais);
        
        Airport air= new Airport();
        AirportSoap airsoap = air.getAirportSoap();
        
        String airports= airsoap.getAirportInformationByCountry(pais);
        
        result[0]= cities;
        result[1]= airports;
        
        return result;
    }
}
