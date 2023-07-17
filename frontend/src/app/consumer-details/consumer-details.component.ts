import { Component, OnInit } from '@angular/core';
import { FormBuilder,FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-consumer-details',
  templateUrl: './consumer-details.component.html',
  styleUrls: ['./consumer-details.component.css']
})
export class ConsumerDetailsComponent implements OnInit {
 
  public consumerDetailsForm!: FormGroup
  constructor(private formBuilder:FormBuilder,private http : HttpClient, private router: Router) { }

  ngOnInit(): void {
    this.consumerDetailsForm=this.formBuilder.group({
      consumerId:['',Validators.required],
      consumerName:['',Validators.required],
      consumerDOB:['',Validators.required],
      consumerEmail:['',Validators.required],
      consumerPAN:['',Validators.required],
      consumerType:['',Validators.required]
    })
  }

  onSubmit(){                 
    this.http.post<any>("http://localhost:3000/consumerDetails",this.consumerDetailsForm.value)
    .subscribe(res=>{
      alert("Details Added successfully");
      this.consumerDetailsForm.reset();
      this.router.navigate(['createPolicy'])
    },err=>{
      alert("Something went wrong");
    })
  }

}
