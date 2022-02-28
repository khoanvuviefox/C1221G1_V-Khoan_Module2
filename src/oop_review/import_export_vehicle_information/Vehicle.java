package oop_review.import_export_vehicle_information;

public class Vehicle {
    private String owner;
    private String licensePlate;
    private int cylinderCapacity;
    private long vehiclePrice;

    public Vehicle(String owner, String licensePlate, int cylinderCapacity, long vehiclePrice) {
        this.owner = owner;
        this.licensePlate = licensePlate;
        this.cylinderCapacity = cylinderCapacity;
        this.vehiclePrice = vehiclePrice;
    }

    public Vehicle() {

    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getCylinderCapacity() {
        return cylinderCapacity;
    }

    public void setCylinderCapacity(int cylinderCapacity) {
        this.cylinderCapacity = cylinderCapacity;
    }

    public long getVehiclePrice() {
        return vehiclePrice;
    }

    public void setVehiclePrice(long vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "owner='" + owner + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", cylinderCapacity=" + cylinderCapacity +
                ", vehiclePrice=" + vehiclePrice +
                '}';
    }
}
