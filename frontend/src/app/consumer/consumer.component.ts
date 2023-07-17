import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-consumer',
  templateUrl: './consumer.component.html',
  styleUrls: ['./consumer.component.css'],
})
export class ConsumerComponent implements OnInit {
  public consumerForm!: FormGroup;
  constructor(
    private formBuilder: FormBuilder,
    private http: HttpClient,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.consumerForm = this.formBuilder.group({
      ID: ['', Validators.required],
      First_Name: ['', Validators.required],
      Last_Name: ['', Validators.required],
      DOB: ['', Validators.required],
      Business_Name: ['', Validators.required],
      PAN_Details: ['', Validators.required],
      Email: ['', Validators.required],
      Phone: ['', Validators.required],
      // ANNUAL_TURNOVER:['',Validators.required],
      // TOTAL_EMPLOYEES:['',Validators.required],
      Website: ['', Validators.required],
      Business_Overview: ['', Validators.required],
      Validity_of_Consumer: ['', Validators.required],
      Agent_Name: ['', Validators.required],
      Agent_ID: ['', Validators.required],
    });
  }

  onSubmit() {
    console.log();
    this.router.navigate(['consumer']);
    // this.http.post<any>("http://localhost:3000/consumer",this.consumerForm.value)
    // .subscribe(res=>{
    //   alert("Details Added successfully");
    //   this.consumerForm.reset();
    //   this.router.navigate(['consumer'])
    // },err=>{
    //   alert("Something went wrong");
    // })
  }
}
