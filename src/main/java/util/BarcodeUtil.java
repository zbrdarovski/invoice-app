package util;

public final class BarcodeUtil {

    private BarcodeUtil() {}

    /**
     * The calculateItemTotal method checks if a barcode is valid
     * @param barcode barcode of a given thing
     */
    public static Boolean isBarcodeValid(String barcode){
        StringBuilder str1 = new StringBuilder();
        String str2;

        for(int i = 0; i < barcode.length()-1; i++){
            str1.append(barcode.charAt(i));
        }

        str2 = String.valueOf(barcode.charAt(barcode.length()-1));

        long  b = Long.parseLong(String.valueOf(str1));
        long cd = Long.parseLong(str2);
        int i = 0;
        long temp = b;
        long sum = 0;

        while (temp > 0) {
            i++;
            if(i%2 == 0) {
                sum = sum + (temp % 10);
            } else {
                sum = sum + ((temp % 10) * 3);
            }
            temp = temp / 10;
        }

        long nearestEqualTen = ((sum + 9) / 10) * 10;

        return nearestEqualTen - sum == cd;
    }

    /**
     * The getCompanyCountryFromBarcode parses the first few numbers of a barcode and gives the name of the country where the barcode is issued
     * @param barcode barcode of a given thing
     * @return country name
     */
    public static String getCompanyCountryFromBarcode(String barcode) {
        if (barcode.charAt(0) == '0') {
            return "USA or Canada";
        }
        if (barcode.charAt(0) == '1') {
            return "USA";
        }
        if (barcode.charAt(0) == '3') {
            if (barcode.charAt(1) == '0' || barcode.charAt(1) == '1' || barcode.charAt(1) == '2' || barcode.charAt(1) == '3' ||
                    barcode.charAt(1) == '4' || barcode.charAt(1) == '5' || barcode.charAt(1) == '6' || barcode.charAt(1) == '7') {
                return "France and Monaco";
            }
            if (barcode.charAt(1) == '8') {
                if (barcode.charAt(2) == '0') {
                    return "Bulgaria";
                }
                if (barcode.charAt(2) == '3') {
                    return "Slovenia";
                }
                if (barcode.charAt(2) == '5') {
                    return "Croatia";
                }
                if (barcode.charAt(2) == '7') {
                    return "Bosnia and Herzegovina";
                }
                if (barcode.charAt(2) == '9') {
                    return "Montenegro";
                }
            }
        }
        if (barcode.charAt(0) == '4') {
            if (barcode.charAt(1) == '0' || barcode.charAt(1) == '1' || barcode.charAt(1) == '2' || barcode.charAt(1) == '3' ||
                    barcode.charAt(1) == '4') {
                return "Germany";
            }
            if (barcode.charAt(1) == '5') {
                return "Japan";
            }
            if (barcode.charAt(1) == '6') {
                return "Russia";
            }
            if (barcode.charAt(1) == '7') {
                if (barcode.charAt(2) == '0') {
                    return "Kyrgyzstan";
                }
                if (barcode.charAt(2) == '1') {
                    return "Taiwan";
                }
                if (barcode.charAt(2) == '4') {
                    return "Estonia";
                }
                if (barcode.charAt(2) == '5') {
                    return "Latvia";
                }
                if (barcode.charAt(2) == '6') {
                    return "Azerbaijan";
                }
                if (barcode.charAt(2) == '7') {
                    return "Lithuania";
                }
                if (barcode.charAt(2) == '8') {
                    return "Uzbekistan";
                }
                if (barcode.charAt(2) == '9') {
                    return "Sri Lanka";
                }
            }
                if (barcode.charAt(1) == '8') {
                    if (barcode.charAt(2) == '0') {
                        return "Philippines";
                    }
                    if (barcode.charAt(2) == '1') {
                        return "Belarus";
                    }
                    if (barcode.charAt(2) == '2') {
                        return "Ukraine";
                    }
                    if (barcode.charAt(2) == '4') {
                        return "Moldova";
                    }
                    if (barcode.charAt(2) == '5') {
                        return "Armenia";
                    }
                    if (barcode.charAt(2) == '6') {
                        return "Georgia";
                    }
                    if (barcode.charAt(2) == '7') {
                        return "Kazakhstan";
                    }
                    if (barcode.charAt(2) == '8') {
                        return "Tajikistan";
                    }
                    if (barcode.charAt(2) == '9') {
                        return "Hong Kong";
                    }
                }
                if(barcode.charAt(1) == '9'){
                    return "Japan";
                }
        }
        if(barcode.charAt(0) == '5'){
            if(barcode.charAt(1) == '0'){
                return "United Kingdom";
            }
            if(barcode.charAt(1) == '2'){
                if(barcode.charAt(2) == '0' || barcode.charAt(2) == '1'){
                    return "Greece";
                }
                if(barcode.charAt(2) == '8'){
                    return "Lebanon";
                }
                if(barcode.charAt(2) == '9'){
                    return "Cyprus";
                }
            }
            if(barcode.charAt(1) == '3'){
                if(barcode.charAt(2) == '0'){
                    return "Albania";
                }
                if(barcode.charAt(2) == '1'){
                    return "North Macedonia";
                }
                if(barcode.charAt(2) == '5'){
                    return "Malta";
                }
                if(barcode.charAt(2) == '9'){
                    return "Ireland";
                }
            }
            if(barcode.charAt(1) == '4') {
                return "Belgium and Luxembourg";
            }
            if(barcode.charAt(1) == '6') {
                if(barcode.charAt(2) == '0'){
                    return "Portugal";
                }
                if(barcode.charAt(2) == '9'){
                    return "Iceland";
                }
            }
            if(barcode.charAt(1) == '7') {
                if(barcode.charAt(2) == '0'){
                    return "Denmark";
                }
            }
            if(barcode.charAt(1) == '9') {
                if(barcode.charAt(2) == '0'){
                    return "Poland";
                }
                if(barcode.charAt(2) == '4'){
                    return "Romania";
                }
                if(barcode.charAt(2) == '9'){
                    return "Hungary";
                }
            }
        }
        if(barcode.charAt(0) == '6'){
            if(barcode.charAt(1) == '0'){
                if(barcode.charAt(2) == '0' || barcode.charAt(2) == '1'){
                    return "South Africa";
                }
                if(barcode.charAt(2) == '3'){
                    return "Ghana";
                }
                if(barcode.charAt(2) == '4'){
                    return "Senegal";
                }
                if(barcode.charAt(2) == '8'){
                    return "Bahrain";
                }
                if(barcode.charAt(2) == '9'){
                    return "Mauritius";
                }
            }
            if(barcode.charAt(1) == '1'){
                if(barcode.charAt(2) == '1'){
                    return "Morocco";
                }
                if(barcode.charAt(2) == '3'){
                    return "Algeria";
                }
                if(barcode.charAt(2) == '5'){
                    return "Nigeria";
                }
                if(barcode.charAt(2) == '6'){
                    return "Kenya";
                }
                if(barcode.charAt(2) == '8'){
                    return "Cote d'Ivoire";
                }
                if(barcode.charAt(2) == '9'){
                    return "Tunisia";
                }
            }
            if(barcode.charAt(1) == '2') {
                if (barcode.charAt(2) == '0') {
                    return "Tanzania";
                }
                if (barcode.charAt(2) == '1') {
                    return "Syria";
                }
                if (barcode.charAt(2) == '2') {
                    return "Egypt";
                }
                if (barcode.charAt(2) == '3') {
                    return "Brunei";
                }
                if (barcode.charAt(2) == '4') {
                    return "Libya";
                }
                if (barcode.charAt(2) == '5') {
                    return "Jordan";
                }
                if (barcode.charAt(2) == '6') {
                    return "Iran";
                }
                if (barcode.charAt(2) == '7') {
                    return "Kuwait";
                }
                if (barcode.charAt(2) == '8') {
                    return "Saudi Arabia";
                }
                if (barcode.charAt(2) == '9') {
                    return "United Arab Emirates";
                }
            }
            if(barcode.charAt(1) == '4') {
                return "Finland";
            }
            if(barcode.charAt(1) == '9') {
                return "China";
            }
        }
        if(barcode.charAt(0) == '7'){
            if(barcode.charAt(1) == '0'){
                return "Norway";
            }
            if(barcode.charAt(1) == '2'){
                if(barcode.charAt(2) == '9'){
                    return "Israel";
                }
            }
            if(barcode.charAt(1) == '3'){
                return "Sweden";
            }
            if(barcode.charAt(1) == '4'){
                if(barcode.charAt(2) == '0'){
                    return "Guatemala";
                }
                if(barcode.charAt(2) == '1'){
                    return "El Salvador";
                }
                if(barcode.charAt(2) == '2'){
                    return "Honduras";
                }
                if(barcode.charAt(2) == '3'){
                    return "Nicaragua";
                }
                if(barcode.charAt(2) == '4'){
                    return "Costa Rica";
                }
                if(barcode.charAt(2) == '5'){
                    return "Panama";
                }
                if(barcode.charAt(2) == '6'){
                    return "Dominic Republic";
                }
            }
            if(barcode.charAt(1) == '5') {
                if(barcode.charAt(2) == '0'){
                    return "Mexico";
                }
                if(barcode.charAt(2) == '4' || barcode.charAt(2) == '5'){
                    return "Canada";
                }
                if(barcode.charAt(2) == '9'){
                    return "Venezuela";
                }
            }
            if(barcode.charAt(1) == '6') {
                return "Switzerland and Liechtenstein";
            }
            if(barcode.charAt(1) == '7') {
                if(barcode.charAt(2) == '0' || barcode.charAt(2) == '1') {
                    return "Colombia";
                }
                if(barcode.charAt(2) == '3'){
                    return "Uruguay";
                }
                if(barcode.charAt(2) == '5'){
                    return "Peru";
                }
                if(barcode.charAt(2) == '7'){
                    return "Bolivia";
                }
                if(barcode.charAt(2) == '8' || barcode.charAt(2) == '9'){
                    return "Argentina";
                }
            }
            if(barcode.charAt(1) == '8') {
                if(barcode.charAt(2) == '0'){
                    return "Chile";
                }
                if(barcode.charAt(2) == '4'){
                    return "Paraguay";
                }
                if(barcode.charAt(2) == '6'){
                    return "Ecuador";
                }
                if(barcode.charAt(2) == '9'){
                    return "Brazil";
                }
            }
            if(barcode.charAt(1) == '9') {
                if(barcode.charAt(2) == '0'){
                    return "Brazil";
                }
            }
        }
        if(barcode.charAt(0) == '8'){
            if(barcode.charAt(1) == '0' || barcode.charAt(1) == '1' || barcode.charAt(1) == '2' || barcode.charAt(1) == '3'){
                return "Italy";
            }
            if(barcode.charAt(1) == '4'){
                return "Spain";
            }
            if(barcode.charAt(1) == '5'){
                if(barcode.charAt(2) == '0') {
                    return "Cuba";
                }
                if(barcode.charAt(2) == '8') {
                    return "Slovakia";
                }
                if(barcode.charAt(2) == '9') {
                    return "Czech Republic";
                }
            }
            if(barcode.charAt(1) == '6') {
                if (barcode.charAt(2) == '0') {
                    return "Serbia";
                }
                if (barcode.charAt(2) == '5') {
                    return "Mongolia";
                }
                if (barcode.charAt(2) == '7') {
                    return "North Korea";
                }
            }
            if(barcode.charAt(1) == '7') {
                if(barcode.charAt(2) == '1') {
                    return "Israel";
                }
                return "Netherlands";
            }
            if(barcode.charAt(1) == '8') {
                if (barcode.charAt(2) == '0') {
                    return "South Korea";
                }
                if (barcode.charAt(2) == '4') {
                    return "Cambodia";
                }
                if (barcode.charAt(2) == '5') {
                    return "Thailand";
                }
                if (barcode.charAt(2) == '8') {
                    return "Singapore";
                }
            }
            if(barcode.charAt(1) == '9') {
                if (barcode.charAt(2) == '0') {
                    return "India";
                }
                if (barcode.charAt(2) == '3') {
                    return "Vietnam";
                }
                if (barcode.charAt(2) == '4') {
                    return "Bangladesh";
                }
                if (barcode.charAt(2) == '6') {
                    return "Pakistan";
                }
                if (barcode.charAt(2) == '9') {
                    return "Indonesia";
                }
            }
        }
        if(barcode.charAt(0) == '9'){
            if(barcode.charAt(1) == '0' || barcode.charAt(1) == '1'){
                return "Austria";
            }
            if(barcode.charAt(1) == '3'){
                return "Australia";
            }
            if(barcode.charAt(1) == '4'){
                return "New Zealand";
            }
            if(barcode.charAt(1) == '5'){
                if(barcode.charAt(2) == '5'){
                    return "Malaysia";
                }
                if(barcode.charAt(2) == '8'){
                    return "Macau";
                }
            }
            if(barcode.charAt(1) == '6'){
                return "GS1 Global Office: GTIN-8 allocations";
            }
            if(barcode.charAt(1) == '7') {
                if(barcode.charAt(2) == '7') {
                    return "Serial publications";
                }
                if(barcode.charAt(2) == '8' || barcode.charAt(2) == '9') {
                    return "Bookland";
                }
            }
        }
        return "Invalid\n";
    }
}