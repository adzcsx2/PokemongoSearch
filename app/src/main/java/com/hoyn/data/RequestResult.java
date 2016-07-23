package com.hoyn.data;

import java.util.List;

/**
 * Created by Hoyn on 2016/7/23.
 */
public class RequestResult {

    /**
     * status : success
     * pokemon : [{"id":"76492678","data":"[]","expiration_time":1469236346,"pokemonId":"41","latitude":37.761540254109,"longitude":-122.38969175558,"uid":"808f7fb81b5:41","is_alive":true},{"id":"76622979","data":"[]","expiration_time":1469236491,"pokemonId":"133","latitude":37.751898566011,"longitude":-122.40119799995,"uid":"808f7fb32c5:133","is_alive":true},{"id":"76658622","data":"[]","expiration_time":1469236420,"pokemonId":"16","latitude":37.757933610425,"longitude":-122.39367482867,"uid":"808f7fb6eff:16","is_alive":true},{"id":"76818941","data":"[]","expiration_time":1469236500,"pokemonId":"41","latitude":37.765580906232,"longitude":-122.39084243662,"uid":"808f7fc8bcd:41","is_alive":true},{"id":"77016299","data":"[]","expiration_time":1469236739,"pokemonId":"41","latitude":37.758263152974,"longitude":-122.38969175558,"uid":"808f7fb9887:21","is_alive":true},{"id":"77016332","data":"[]","expiration_time":1469236524,"pokemonId":"21","latitude":37.758034799999,"longitude":-122.38800996836,"uid":"808f7fb9887:21","is_alive":true},{"id":"77016360","data":"[]","expiration_time":1469236687,"pokemonId":"19","latitude":37.757612934489,"longitude":-122.38986878425,"uid":"808f7fb9887:21","is_alive":true},{"id":"77016398","data":"[]","expiration_time":1469236674,"pokemonId":"19","latitude":37.757768965206,"longitude":-122.38960324113,"uid":"808f7fb9887:21","is_alive":true},{"id":"77016440","data":"[]","expiration_time":1469236775,"pokemonId":"84","latitude":37.757276912569,"longitude":-122.38756738831,"uid":"808f7fb9887:21","is_alive":true},{"id":"77016469","data":"[]","expiration_time":1469236517,"pokemonId":"69","latitude":37.757222550145,"longitude":-122.38774442056,"uid":"808f7fb9887:21","is_alive":true},{"id":"77162650","data":"[]","expiration_time":1469236543,"pokemonId":"41","latitude":37.7657026621,"longitude":-122.39650714452,"uid":"808f7fcc10b:41","is_alive":true},{"id":"77162791","data":"[]","expiration_time":1469236384,"pokemonId":"17","latitude":37.764836206107,"longitude":-122.3964186358,"uid":"808f7fcc10b:41","is_alive":true},{"id":"77162895","data":"[]","expiration_time":1469236435,"pokemonId":"41","latitude":37.764665964328,"longitude":-122.39721521157,"uid":"808f7fcc10b:41","is_alive":true},{"id":"77169982","data":"[]","expiration_time":1469236492,"pokemonId":"41","latitude":37.757094395983,"longitude":-122.39907386491,"uid":"808f7fb5be9:21","is_alive":true},{"id":"77170112","data":"[]","expiration_time":1469236472,"pokemonId":"16","latitude":37.758903120533,"longitude":-122.39827730321,"uid":"808f7fb5be9:21","is_alive":true},{"id":"77170233","data":"[]","expiration_time":1469236740,"pokemonId":"21","latitude":37.75840306148,"longitude":-122.39748073548,"uid":"808f7fb5be9:21","is_alive":true}]
     */

    private String status;
    /**
     * id : 76492678
     * data : []
     * expiration_time : 1469236346
     * pokemonId : 41
     * latitude : 37.761540254109
     * longitude : -122.38969175558
     * uid : 808f7fb81b5:41
     * is_alive : true
     */

    private List<PokemonBean> pokemon;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<PokemonBean> getPokemon() {
        return pokemon;
    }

    public void setPokemon(List<PokemonBean> pokemon) {
        this.pokemon = pokemon;
    }

    public static class PokemonBean {
        private String id;
        private String data;
        private int expiration_time;
        private String pokemonId;
        private double latitude;
        private double longitude;
        private String uid;
        private boolean is_alive;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public int getExpiration_time() {
            return expiration_time;
        }

        public void setExpiration_time(int expiration_time) {
            this.expiration_time = expiration_time;
        }

        public String getPokemonId() {
            return pokemonId;
        }

        public void setPokemonId(String pokemonId) {
            this.pokemonId = pokemonId;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public boolean isIs_alive() {
            return is_alive;
        }

        public void setIs_alive(boolean is_alive) {
            this.is_alive = is_alive;
        }
    }
}
