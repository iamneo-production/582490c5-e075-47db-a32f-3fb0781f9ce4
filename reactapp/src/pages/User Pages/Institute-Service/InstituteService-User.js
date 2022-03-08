import http from './../../../Institutes-http'

class InstituteDataService {

    getAll() {
        return http.get("/getAll");
      }

    findById(id){
        return http.get(`/getById?id=${id}`);
    }

}

export default new InstituteDataService();