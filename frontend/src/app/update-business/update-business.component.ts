import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { ApiService } from '../shared/api.service';

@Component({
  selector: 'app-update-business',
  templateUrl: './update-business.component.html',
  styleUrls: ['./update-business.component.css']
})
export class UpdateBusinessComponent implements OnInit {
  public updateBusinessForm!: FormGroup
  CONSUMER_ID: any;
  id: any;
  businessData:any;


  CONSUMER_NAME: any;
  constructor(private formBuilder: FormBuilder, private http: HttpClient, private router: Router, private route: ActivatedRoute, private api: ApiService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    // console.log("thisis url id ", this.id)
    this.prePopulate(this.id);
    this.updateBusinessForm = this.formBuilder.group({
      ID: ["", Validators.required],
      Consumer_ID: ['', Validators.required],
      Business_Category: ['', Validators.required],
      Business_Type: ['', Validators.required],
      Business_Turnover: ['', Validators.required],
      Capital_Invested: ['', Validators.required],
      Total_Employees: ['', Validators.required],
      Business_Value: ['', Validators.required],
      Business_Age: ['', Validators.required]
    })
  }

  prePopulate(id: any) {
    this.api.getBusinessDataById(id).subscribe(response => {
      // console.log(response)
      this.businessData=response;
      console.log(this.businessData);
    })

  }



  onSubmit() {
    this.http.put<any>('http://localhost:3000/consumer', this.updateBusinessForm.value)
      .subscribe({

        next: data => {
          this.CONSUMER_ID = data.CONSUMER_ID;
          this.CONSUMER_NAME = data.CONSUMER_NAME;

        },
        error: error => {
          alert(this.updateBusinessForm.value);
        }
      });

  }
}


