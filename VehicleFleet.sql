connect sys as sysdba;
DROP USER vehiclefleet CASCADE;
create user vehiclefleet identified by 123;

GRANT connect, resource to vehiclefleet;

connect vehiclefleet/123;

create table GasVehicle(
    TripCounter INT NOT NULL CHECK (TripCounter > 0), 
    EnergyConsumed FLOAT(53) NOT NULL CHECK (EnergyConsumed > 0), 
    SerialNumber varchar2(50) NOT NULL, 
    Model INT NOT NULL CHECK (Model > 0), 
    Made varchar2(50) NOT NULL);

create unique index IDX_GasVehicle_SerialNumber on GasVehicle(SerialNumber);

alter table GasVehicle Add constraint CK_GasVehicle_SerialNumber CHECK(SerialNumber IS NOT NULL);

create table ElectricVehicle(
    TripCounter INT NOT NULL CHECK (TripCounter > 0), 
    KwPowerConsumed FLOAT(53) NOT NULL CHECK (KwPowerConsumed > 0), 
    SerialNumber varchar2(50) NOT NULL, 
    Model INT NOT NULL CHECK (Model > 0), 
    Made varchar2(50) NOT NULL);

create unique index IDX_ElecVehicle_SerialNumber on ElectricVehicle(SerialNumber);

alter table ElectricVehicle Add constraint CK_ElecVehicle_SerialNumber CHECK(SerialNumber IS NOT NULL);

desc ElectricVehicle;
desc Gasvehicle;

insert into ElectricVehicle values(10, 10.5, 'Chevy1', 10, 'Chevy');
insert into ElectricVehicle values(20, 10.5, 'Chevy2', 10, 'Chevy');

insert into GasVehicle values(10, 20, 'Honda1', 10, 'Honda');
insert into GasVehicle values(20, 15, 'Honda2', 10, 'Honda');

commit;