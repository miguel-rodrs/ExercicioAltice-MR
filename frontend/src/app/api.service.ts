import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
    private apiUrl = 'localhost';
    private port = '8080';
    private service = 'labseq';

    constructor(private http: HttpClient) {}

    fetchData(n: number): Observable<any> {
        return this.http.get(`http://${this.apiUrl}:${this.port}/${this.service}/${n}`,  { responseType: 'text' });
    }
}