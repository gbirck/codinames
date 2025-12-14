package com.gabrielbirck.codinames.Service;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.node.ArrayNode;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class CodinameService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Environment env;

    private List<String> avengersCodinameList = new ArrayList<>();
    private List<String> justiceLeagueCodinameList = new ArrayList<>();

    ObjectMapper objectMapper = new ObjectMapper();

    @PostConstruct
    public void loadJsonData() {
        try {
            String codinameResponse = restTemplate.getForObject(env.getProperty("avengers"), String.class);
            JsonNode jsonNode = objectMapper.readTree(codinameResponse);

            ArrayNode avengersArray = (ArrayNode) jsonNode.get("vingadores");

            for (JsonNode avenger : avengersArray) {
                avengersCodinameList.add(avenger.get("codinome").asText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostConstruct
    public void loadXmlData() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(env.getProperty("justice.league"));

            NodeList codinameList = doc.getElementsByTagName("codinome");

            for (int i = 0; i < codinameList.getLength(); i++) {
                Element codinameElement = (Element) codinameList.item(i);
                String codiname = codinameElement.getTextContent();
                this.justiceLeagueCodinameList.add(codiname);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
