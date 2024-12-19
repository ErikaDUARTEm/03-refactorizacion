package org.example.booking.entities;

public class PriceCalculation {

    private PriceCalculation() {
    }

    public static double calculateTotalPrice(double basePrice, double totalDays, int numberOfConfirmedRooms){
        return basePrice * totalDays * numberOfConfirmedRooms;
    }
    public static double calculatePriceAdjustment(int availableCheckInDate, int availableCheckOutDate, double totalPrice){
        // últimos dos dígitos para el día de inicio
        int start = availableCheckInDate % 100;
        //  últimos dos dígitos para el día de fin
        int end = availableCheckOutDate % 100;

        double adjustment;
        if (start >= 26) {
            // Sube el precio 15%
            adjustment = totalPrice * 1.15;
        } else if (start >= 10 && end <= 15) {
            // Sube el precio 10%
            adjustment = totalPrice * 1.10;
        } else if (start >= 5 && end <= 10) {
            // Baja el precio 8%
            adjustment = totalPrice * 0.92;
        } else {
            // Sin cambios si no aplica ninguna regla
            adjustment = totalPrice;
        }

        return adjustment;
    };
}
