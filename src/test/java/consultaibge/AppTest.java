package consultaibge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static io.restassured.RestAssured.*;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void testSucesso()
    {
        //URL
        baseURI = "https://viacep.com.br/";
        basePath = "/ws";

        //consultar CEP e retorna IBGE
        String ibge = when()
            .get("/05140040/json/")
        .then()
        
            .assertThat()
                .statusCode(200)
                .extract()
                .path("ibge");
        
        assertEquals("3550308", ibge);        

    }

    @Test
    public void testError(){
        //URL
        baseURI = "https://viacep.com.br/";
        basePath = "/ws";

        //consultar CEP Inválido e retorna 400
        when()
            .get("/355030/json/")
        .then()
            .assertThat()
                .statusCode(400);

    }
}
