package es.upm.dit.apsv.traceserver.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Trace {

    @Id
    private String traceId; // Clave primaria: concatenación de truck + timestamp

    private String truck;   // ID del camión
    private long lastSeen;  // Timestamp (última vez que fue visto)
    private double lat;     // Latitud
    private double lng;     // Longitud

    // Constructor con todos los campos
    public Trace(String traceId, String truck, long lastSeen, double lat, double lng) {
        this.traceId = traceId;
        this.truck = truck;
        this.lastSeen = lastSeen;
        this.lat = lat;
        this.lng = lng;
    }

    // Generar hashCode y equals
    @Override
    public int hashCode() {
        return Objects.hash(traceId, truck, lastSeen, lat, lng);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Trace other = (Trace) obj;
        return Objects.equals(traceId, other.traceId) &&
               Objects.equals(truck, other.truck) &&
               lastSeen == other.lastSeen &&
               Double.compare(other.lat, lat) == 0 &&
               Double.compare(other.lng, lng) == 0;
    }
}
