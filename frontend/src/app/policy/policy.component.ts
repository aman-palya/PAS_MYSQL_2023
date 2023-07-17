import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ApiService } from '../shared/api.service';
import { PolicyData } from './Policy.model';
@Component({
  selector: 'app-policy',
  templateUrl: './policy.component.html',
  styleUrls: ['./policy.component.css'],
})
export class PolicyComponent implements OnInit {
  Obj: PolicyData = new PolicyData();
  allPolicyData: any;
  createPolicyForm!: FormGroup;
  //viewPolicyForm !:FormGroup;
  constructor(private formBuilder: FormBuilder, private api: ApiService) {}

  ngOnInit(): void {
    this.createPolicyForm = this.formBuilder.group({
      POLICY_ID: [''],
      PROPERTY_TYPE: [''],
      CONSUMER_TYPE: [''],
      ASSURED_SUM: [''],
      TENURE: [''],
      BUSINESS_VALUE: [''],
      PROPERTY_VALUE: [''],
      BASE_LOCATION: [''],
      STATUS: [''],
    });
    this.getAllData();
  }

  createPolicy() {
    this.Obj.POLICY_ID = this.createPolicyForm.value.POLICY_ID;
    this.Obj.PROPERTY_TYPE = this.createPolicyForm.value.PROPERTY_TYPE;
    this.Obj.CONSUMER_TYPE = this.createPolicyForm.value.CONSUMER_TYPE;
    this.Obj.ASSURED_SUM = this.createPolicyForm.value.ASSURED_SUM;
    this.Obj.TENURE = this.createPolicyForm.value.TENURE;
    this.Obj.BUSINESS_VALUE = this.createPolicyForm.value.BUSINESS_VALUE;
    this.Obj.PROPERTY_VALUE = this.createPolicyForm.value.PROPERTY_VALUE;
    this.Obj.BASE_LOCATION = this.createPolicyForm.value.BASE_LOCATION;
    this.Obj.STATUS = this.createPolicyForm.value.STATUS;

    this.api.postCreatePolicy(this.Obj).subscribe(
      (res) => {
        console.log(res);
        alert('Policy Created Successfully!!');
        let ref = document.getElementById('clear');
        this.createPolicyForm.reset();
      },
      (err) => {
        alert('Something went wrong');
      }
    );
  }

  getAllData() {
    // this.api.getPolicy().subscribe(res=>{
    //   console.log("Result"+res.value);
    //   this.allPolicyData=res;
    // })
  }
}
