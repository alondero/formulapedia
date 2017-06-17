import { Component, Injectable } from '@angular/core';
import {Http, Response} from '@angular/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

@Injectable()
export class AppComponent {
  drivers: string;

  constructor(private http: Http) {
     this.http.get('http://192.168.99.100:8080/drivers').subscribe(
       res => this.drivers = JSON.stringify(res.json()),
       error => console.log(error)
     );
  }

  title = 'Formulapedia';
  
}
