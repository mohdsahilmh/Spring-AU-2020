import { Component, OnInit } from '@angular/core';
import { DataServiceService } from '../providers/data-service.service';

@Component({
  selector: 'app-view-component',
  templateUrl: './view-component.component.html',
  styleUrls: ['./view-component.component.css']
})
export class ViewComponentComponent implements OnInit {

  constructor(private dataservice:DataServiceService) { }
  map = this.dataservice.map
  
  delete(id){
    this.map.delete(id);
  }
  ngOnInit() {
    this.map = this.dataservice.getdata()
  }
  

}
