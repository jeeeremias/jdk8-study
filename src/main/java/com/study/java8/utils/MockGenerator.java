package com.study.java8.utils;

import com.study.java8.enums.Color;
import com.study.java8.model.Car;

import java.util.*;

public class MockGenerator {
    private static final String[][] names = {{"Agrale", "Marruá"},
            {"Aston Martin", "DB9 Volante", "DBS Volante", "DBS Coupe", "Rapide", "V12 Vantage Coupe",
                    "V8 Vantage Coupe", "V8 Vantage Roadster", "Virage"},
            {"Audi", "A1", "A3", "A3 Sedan", "A4", "A4 Avant", "A5", "A7", "A8", "Q3", "Q5", "Q7", "R8",
                    "R8 GT", "RS 3 Sportback", "RS 5", "RS6 Avant", "TT Coupé", "TT Roadster"},
            {"Bentley", "Continental Flying Spur", "Continental Supersports Coupé"},
            {"BMW", "Série 1", "Série 1 Cabrio", "Série 1 Coupé", "Série 1 M", "Série 3 Cabrio",
                    "Série 3 M3 Coupé", "Série 3 M3 Sedã", "Série 3 Sedã", "Série 5 Gran Turismo",
                    "Série 5 Sedã", "Série 7 Sedã", "X1", "X3", "X4", "X5", "X6", "Z4 Roadster", "i3"},
            {"Changan", "Chana Cargo", "Chana Family", "Chana Utility"},
            {"Chery", "Celer Hatch", "Celer Sedan", "Cielo Hatch", "Cielo Sedan", "Face", "QQ",
                    "S-18", "Tiggo"},
            {"GM/Chevrolet", "Agile", "Astra Hatch", "Astra Sedan", "Blazer", "Camaro", "Captiva",
                    "Celta", "Classic", "Cobalt", "Corsa Hatch", "Corsa Sedã", "Cruze", "Cruze Sport6",
                    "Malibu", "Meriva", "Montana", "Omega", "Onix", "Prisma", "S10", "Sonic", "Spin",
                    "Tracker", "Trailblazer", "Vectra", "Vectra GT", "Zafira"},
            {"Chrysler", "300C", "Town & Country"},
            {"Citroën", "Aircross", "C3", "C3 Picasso", "C4", "C4 Lounge", "C4 Pallas", "C4 Picasso",
                    "C5", "C5 Tourer", "DS3", "DS5", "Jumper", "Xsara Picasso"},
            {"Dodge", "Durango", "Journey"},
            {"Effa", "Effa Hafei Furgão", "Effa Hafei Picape Baú", "Effa Hafei Picape Cabine Dupla",
                    "Effa Hafei Picape Cabine Simples", "Effa Hafei Van", "Effa M100"},
            {"Ferrari", "458", "California", "F599 GTO"},
            {"Fiat", "500", "500 Abarth", "Bravo", "Doblò", "Doblò Cargo", "Ducato", "Fiat Mobi",
                    "Fiat Toro", "Fiorino", "Freemont", "Grand Siena", "Idea", "Linea", "Mille",
                    "Palio", "Palio Adventure", "Palio Weekend", "Punto", "Siena EL", "Strada", "Uno"},
            {"Ford", "Courier", "EcoSport", "Edge", "F-250", "Fiesta Rocam Hatch", "Fiesta Rocam Sedan",
                    "Focus Fastback", "Focus Hatch", "Fusion", "Ka", "Ka+", "New Fiesta",
                    "New Fiesta Hatch", "Ranger", "Transit"},
            {"Geely", "EC7", "GC2"},
            {"Hafei", "Pick-up", "Towner Furgão", "Towner Jr", "Towner Passageiro"},
            {"Honda", "Accord", "CR-V", "City", "Civic", "Civic Si", "Fit", "HR-V"},
            {"Hyundai", "Azera", "Elantra", "Equus", "HB20", "HB20S", "HB20X", "HR", "Santa Fe",
                    "Sonata", "Tucson", "Veloster", "Veracruz", "i30", "i30 CW", "iX35"},
            {"Iveco", "Daily 35S14"},
            {"Jac Motors", "J2", "J3", "J3 Turin", "J5", "J6", "T5", "T6"},
            {"Jaguar", "F-Pace", "F-Type Coupé", "XE", "XF", "XJ Supersport", "XKR"},
            {"Jeep", "Cherokee", "Compass", "Grand Cherokee", "Jeep Renegade", "Wrangler"},
            {"Jinbei", "Topic Furgão", "Topic Passageiro"},
            {"Kia", "Bongo", "Cadenza", "Carens", "Carnival", "Cerato", "Mohave", "Optima",
                    "Picanto", "Sorento", "Soul", "Sportage"},
            {"Lamborghini", "Gallardo LP 560 - 4", "Gallardo LP 560 - 4 Spyder"},
            {"Land Rover", "Defender", "Discovery 4", "Discovery Sport", "Freelander 2",
                    "Range Rover Evoque", "Range Rover Sport", "Range Rover Vogue"},
            {"Lexus", "NX 200t"},
            {"Lifan", "320", "530", "620", "X60"},
            {"Mahindra", "Mahindra Picape", "Mahindra SUV"},
            {"Maserati", "Ghibli", "Gran Cabrio", "Gran Turismo", "Quattroporte"},
            {"Mercedes-Benz", "CLA", "Classe A", "Classe B", "Classe C", "Classe C 250 Turbo Sport",
                    "Classe C 63 AMG Touring", "Classe CL", "Classe CLS 63 AMG", "Classe E",
                    "Classe G", "Classe GL", "Classe GLK", "Classe M", "Classe S",
                    "Classe S 400 Hybrid", "Classe SLK", "Classe SLS AMG", "GLA", "GLC",
                    "GLC Coupé"},
            {"MG Motors", "MG 550", "MG 6"},
            {"Mini", "Cooper", "Cooper Cabrio", "Cooper Countryman", "Cooper S Clubman-Hampton",
                    "Mini Clubman", "Cooper S Clubman-Hampton", "One"},
            {"Mitsubishi", "ASX", "L200 Outdoor", "L200 Savana", "L200 Triton", "Lancer",
                    "Lancer Evolution X", "Outlander", "Pajero Dakar", "Pajero Full", "Pajero Sport",
                    "Pajero TR4"},
            {"Nissan", "Altima", "Frontier", "Grand Livina", "Kicks", "Livina", "March", "Sentra",
                    "Tiida Hatch", "Tiida Sedan", "Versa"},
            {"Peugeot", "2008", "207", "207 SW", "207 Sedan", "208", "3008", "307", "308", "308 CC",
                    "408", "508", "Boxer", "Hoggar", "Partner", "RCZ"},
            {"Porsche", "911", "Boxster", "Boxster S", "Cayenne", "Cayman", "Cayman S", "Macan",
                    "Panamera"},
            {"Ram", "2500"},
            {"Renault", "Alaskan", "Clio", "Duster", "Fluence", "Grand Tour", "Kangoo Express",
                    "Logan", "Master", "Oroch", "Sandero", "Sandero RS", "Sandero Stepway", "Symbol"},
            {"Smart", "Fortwo MHD", "Fortwo Passion Cabrio", "Fortwo Passion Coupé"},
            {"Ssangyong", "Actyon Sports", "Korando", "Kyron"},
            {"Subaru", "Forester", "Impreza Hatch", "Legacy", "Impreza Sedã", "Outback", "Tribeca"},
            {"Suzuki", "Grand Vitara", "Jimny", "S-Cross", "SX4"},
            {"Toyota", "Camry", "Corolla", "Etios Hatch", "Etios Hatch", "Etios Sedã", "Hilux",
                    "Prius", "RAV4", "SW4"},
            {"Troller", "T4"},
            {"Volkswagen", "Amarok", "Crossfox", "Fox", "Fusca", "Gol", "Gol" ,"Gol G4", "Golf",
                    "Golf Variant", "Jetta", "Jetta Variant", "Kombi", "Parati", "Passat",
                    "Passat Variant", "Polo", "Polo Sedan", "Saveiro", "Space Cross", "SpaceFox",
                    "Tiguan", "Touareg", "Up!", "Voyage"},
            {"Volvo", "C30", "S60", "V40", "XC60", "XC90"}};

    public static List<Car> generateCars(int amount) {
        List<Car> cars = new ArrayList<>();
        Random r = new Random(1000);
        int id = 0;
        while (cars.size() < amount) {
            for (String[] brand: names) {
                for (int i = 1; i < brand.length; i ++) {
                    cars.add(new Car(id ++, r.nextInt(150) + 200, r.nextDouble(),
                            Color.values()[r.nextInt(Color.getTotalElements())], brand[0], brand[i], 5));
                }
            }
        }
        return cars;
    }
}
