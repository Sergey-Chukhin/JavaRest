package org.donstu;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpServer;
import org.donstu.domain.Voyage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SimpleRestService {
    private static final int PORT = 8091;
    private static final int OK = 200;
    private static final int NOT_ALLOWED = 405;
    private static final int NOT_FOUND = 404;

    private static List<Voyage> voyages = new ArrayList<>();

    static {
        voyages.add(new Voyage("Greece in eight days","Piraeus - Crete - Rhodes - Olympia - Corfu - Piraeus", new Date(), 8, "First"));
        voyages.add(new Voyage("Circle of Asia","Tokyo - Shanghai - Taipei - Hong Kong - Nha Trang - Singapore", new Date(), 19, "Second"));
        voyages.add(new Voyage("Mystical beauty","Bermuda - Bahamas - Bermuda", new Date(), 7, "Second"));
        voyages.add(new Voyage("Antarctic summer","Argentina - Antarctica", new Date(), 15, "First"));
    }

    public static void main(String[] args) {
        try {
            HttpServer httpServer = HttpServer.create(new InetSocketAddress(PORT), 0);
            /// ----------------------------------------------------------
            httpServer.createContext("/voyages/list", httpExchange -> {
                if ("GET".equals(httpExchange.getRequestMethod())) {
                    httpExchange.getResponseHeaders().set("Content-Type", "application/json");
                    httpExchange.sendResponseHeaders(OK, 0);
                    ObjectMapper mapper = new ObjectMapper();
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    mapper.writeValue(baos, voyages);
                    byte[] body = baos.toByteArray();
                    OutputStream os = httpExchange.getResponseBody();
                    os.write(body);
                    os.close();
                } else {
                    httpExchange.sendResponseHeaders(NOT_ALLOWED, -1);
                }
            });

            httpServer.createContext("/voyages/title", httpExchange -> {
                if ("GET".equals(httpExchange.getRequestMethod())) {
                    String[] requestParts = httpExchange.getRequestURI().getPath().split("/");
                    if (requestParts.length == 4) {
                        String voyageTitle = requestParts[3];
                        Voyage foundVoyage = null;
                        for (Voyage voyage: voyages) {
                            if (voyage.getTitle().equalsIgnoreCase(voyageTitle)) {
                                foundVoyage = voyage;
                                break;
                            }
                        }
                        if (foundVoyage != null) {
                            httpExchange.getResponseHeaders().set("Content-Type", "application/json");
                            httpExchange.sendResponseHeaders(OK, 0);
                            ObjectMapper mapper = new ObjectMapper();
                            ByteArrayOutputStream baos = new ByteArrayOutputStream();
                            mapper.writeValue(baos, foundVoyage);
                            byte[] body = baos.toByteArray();
                            OutputStream os = httpExchange.getResponseBody();
                            os.write(body);
                            os.close();
                        } else {
                            httpExchange.getResponseHeaders().set("Content-Type", "application/json");
                            httpExchange.sendResponseHeaders(OK, 0);
                            OutputStream os = httpExchange.getResponseBody();
                            os.write("{}".getBytes());
                            os.close();
                        }
                    } else {
                        httpExchange.sendResponseHeaders(NOT_FOUND, -1);
                    }
                } else {
                    httpExchange.sendResponseHeaders(NOT_ALLOWED, -1);
                }
            });


            httpServer.createContext("/voyages/id", httpExchange -> {
                if ("GET".equals(httpExchange.getRequestMethod())) {
                    String[] requestParts = httpExchange.getRequestURI().getPath().split("/");
                    if (requestParts.length == 4) {
                        String voyageId = requestParts[3];
                        Voyage foundVoyage = null;
                        for (Voyage voyage: voyages) {
                            if (voyage.getIdent().equalsIgnoreCase(voyageId)) {
                                foundVoyage = voyage;
                                break;
                            }
                        }
                        if (foundVoyage != null) {
                            httpExchange.getResponseHeaders().set("Content-Type", "application/json");
                            httpExchange.sendResponseHeaders(OK, 0);
                            ObjectMapper mapper = new ObjectMapper();
                            ByteArrayOutputStream baos = new ByteArrayOutputStream();
                            mapper.writeValue(baos, foundVoyage);
                            byte[] body = baos.toByteArray();
                            OutputStream os = httpExchange.getResponseBody();
                            os.write(body);
                            os.close();
                        } else {
                            httpExchange.getResponseHeaders().set("Content-Type", "application/json");
                            httpExchange.sendResponseHeaders(OK, 0);
                            OutputStream os = httpExchange.getResponseBody();
                            os.write("{}".getBytes());
                            os.close();
                        }
                    } else {
                        httpExchange.sendResponseHeaders(NOT_FOUND, -1);
                    }
                } else {
                    httpExchange.sendResponseHeaders(NOT_ALLOWED, -1);
                }
            });



            httpServer.setExecutor(null);
            httpServer.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
