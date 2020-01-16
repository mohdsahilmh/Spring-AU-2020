import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DataServiceService {
 

  constructor() { }
  map = new Map();
  putdata(id,name,email) {
    this.map.set(id,{Name:name,Email:email})
  }
  getdata(){
    return this.map;
  }

}
