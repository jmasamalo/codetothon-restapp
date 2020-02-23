package com.codeathon.restapp.service;


import com.codeathon.restapp.model.Brewery;
import com.codeathon.restapp.model.BreweryListResponse;
import com.codeathon.restapp.model.BreweryResponse;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;
import static org.powermock.api.easymock.PowerMock.*;

@SpringBootTest
@PrepareForTest(BreweryService.class)
@RunWith(PowerMockRunner. class)
public class BreweryServiceTest {
    private static final String BREWERIES_KEY = "breweries?key=";
    private static final String BREWERY = "brewery/";
    private static final String KEY = "?key=";


    private static final String  URL_STRING = "https://sandbox-api.brewerydb.com/v2/";
    private static final String  KEY_STRING = "5865f650b89955e6f423714b51a83354";

    @Mock
    BreweryService breweryServiceMock;
    @Mock
    RestTemplate restTemplateMock;
    @Mock
    BreweryListResponse breweryListResponseMock;
    @Mock
    BreweryResponse breweryResponseMock;

    @Before
    public void setUp() {
        restTemplateMock = mock(RestTemplate.class);
        breweryListResponseMock = mock(BreweryListResponse.class);
        breweryResponseMock = mock(BreweryResponse.class);
    }

    @Ignore
    @Test
    public void getBreweriesSuccess() {
        List<Brewery> data = createData();
        breweryServiceMock = createPartialMockForAllMethodsExcept(BreweryService.class, "getBreweries");
        breweryServiceMock.restTemplate = restTemplateMock;
        expect(restTemplateMock.getForEntity(URL_STRING+BREWERIES_KEY+KEY_STRING, BreweryListResponse.class)).andReturn(new ResponseEntity<>(breweryListResponseMock, HttpStatus.OK));
        expect(breweryListResponseMock.getData()).andReturn(data);

        replayAll();
        assertEquals(data.get(0).getId(), breweryServiceMock.getBreweries().getData().get(0));
        verifyAll();
    }
    @Ignore
    @Test
    public void getBreweriesFailure() {
        List<Brewery> data = createData();
        breweryServiceMock = createPartialMockForAllMethodsExcept(BreweryService.class, "getBreweries");
        breweryServiceMock.restTemplate = restTemplateMock;
        expect(restTemplateMock.getForEntity(URL_STRING+BREWERIES_KEY+KEY_STRING, BreweryListResponse.class)).andReturn(new ResponseEntity<>(breweryListResponseMock, HttpStatus.OK) );
        expect(breweryListResponseMock.getData()).andReturn(null);

        replayAll();
        assertEquals(null, breweryServiceMock.getBreweries().getData());
        verifyAll();
    }

    @Ignore
    @Test
    public void getBrewerySuccess() {
        Brewery b =  getBrewery() ;
        breweryServiceMock = createPartialMockForAllMethodsExcept(BreweryService.class, "getBrewery");
        breweryServiceMock.restTemplate = restTemplateMock;
        expect(restTemplateMock.getForEntity(URL_STRING+BREWERY+"ipo"+KEY+KEY_STRING, BreweryResponse.class)).andReturn(new ResponseEntity<>(breweryResponseMock, HttpStatus.OK) );
        expect(breweryResponseMock.getData()).andReturn(b);

        replayAll();
        assertEquals(b.getId(), breweryServiceMock.getBrewery("ipo").getData().getId());
        verifyAll();
    }

    @Ignore
    @Test
    public void getBreweryFailure() {
        breweryServiceMock = createPartialMockForAllMethodsExcept(BreweryService.class, "getBrewery");
        breweryServiceMock.restTemplate = restTemplateMock;
        expect(restTemplateMock.getForEntity(URL_STRING+BREWERY+"haipo"+KEY+KEY_STRING, BreweryResponse.class)).andReturn(new ResponseEntity<>(breweryResponseMock, HttpStatus.OK) );
        expect(breweryResponseMock.getData()).andReturn(null);

        replayAll();
        assertEquals(null, breweryServiceMock.getBrewery("haipo").getData());
        verifyAll();
    }

    private List<Brewery> createData() {
        List<Brewery> data = new ArrayList<>();
        Brewery b1 = new Brewery();
        b1.setId("Id1");
        Brewery b2 = new Brewery();
        b2.setId("Id2");
        data.add(b1);
        data.add(b2);

        return data;
    }

    private Brewery getBrewery() {
        Brewery b1 = new Brewery();
        b1.setId("Id1");
        return  b1;
    }
}
