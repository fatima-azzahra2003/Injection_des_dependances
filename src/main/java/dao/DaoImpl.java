package dao;

public class DaoImpl implements IDao{
    @Override
    public double getData() {
        System.out.println("Version base de donnes");
        double temp=23;
        return temp;
    }
}
