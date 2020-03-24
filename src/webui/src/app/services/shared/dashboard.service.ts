
import {Injectable} from "@angular/core";
import {ApiService} from "../api.service";
import {Observable} from "rxjs";
import {map} from "rxjs/internal/operators";

@Injectable({
  providedIn: 'root'
})
export class DashboardService{

  private DASHBOARD_PATH = "/dashboard";

  constructor(private apiService: ApiService ){
  }

  getAllPageable(page) : Observable<any>{
    return this.apiService.get(this.DASHBOARD_PATH+'/pagination',page).pipe(map(
      res =>{
        if(res){
          return res;
        }else{
          return {};
        }
      }
    ));
  }

  getAll() : Observable<any>{
    return this.apiService.get(this.DASHBOARD_PATH).pipe(map(
      res =>{
        if(res){
          return res;
        }else{
          return {};
        }
      }
    ));
  }

  getById(id) : Observable<any>{
    return this.apiService.get(this.DASHBOARD_PATH,id).pipe(map(
      res =>{
        if(res){
          return res;
        }else{
          console.log(res);
          return {};
        }
      }
    ));
  }

  createDashboard(dashboard) : Observable<any>{
    return this.apiService.post(this.DASHBOARD_PATH,dashboard).pipe(map(
      res =>{
        if(res){
          return res;
        }else{
          console.log(res);
          return {};
        }
      }
    ));
  }

  delete(id) : Observable<any>{
    return this.apiService.delete(this.DASHBOARD_PATH +'/'+id).pipe(map(
      res =>{
        if(res){
          return res;
        }else{
          console.log(res);
          return {};
        }
      }
    ));
  }
}
