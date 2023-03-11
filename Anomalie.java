import java.util.Date;

public class Anomalie {
    private int id;
    private Date date;
    private String typeAnomalie;
    private int arrondissement;
    private String outil;

    public Anomalie(int id, Date date, String typeAnomalie, int arrondissement, String outil) {
        this.id = id;
        this.date = date;
        this.typeAnomalie = typeAnomalie;
        this.arrondissement = arrondissement;
        this.outil = outil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTypeAnomalie() {
        return typeAnomalie;
    }

    public void setTypeAnomalie(String typeAnomalie) {
        this.typeAnomalie = typeAnomalie;
    }

    public int getArrondissement() {
        return arrondissement;
    }

    public void setArrondissement(int arrondissement) {
        this.arrondissement = arrondissement;
    }

    public String getOutil() {
        return outil;
    }

    public void setOutil(String outil) {
        this.outil = outil;
    }
}

