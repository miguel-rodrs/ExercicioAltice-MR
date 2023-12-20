import { Component } from '@angular/core';
import { ApiService } from './api.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'labseq sequence calculator';

  inputData: number | undefined;
  apiResponse: string | undefined;

  constructor(private apiService: ApiService) {}

  getLabSeq() {
    console.log(this.inputData);
    if (this.inputData) {
      this.apiService.fetchData(this.inputData).subscribe(
        (data) => {
          console.log("BBBBBBBB");
          this.apiResponse = data;
          console.log(this.apiResponse);
        },
        (error) => {
          console.log("pipi")
          console.error('Error fetching data:', error);
        }
      );
    }
  }
}