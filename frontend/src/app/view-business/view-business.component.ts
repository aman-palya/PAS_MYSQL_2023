import { HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ApiService } from '../shared/api.service';
import { BusinessData } from './Business.model';
import { MatDialog } from '@angular/material/dialog';
import { ViewBusinessDialogComponent } from '../view-business-dialog/view-business-dialog.component';

@Component({
  selector: 'app-view-business',
  templateUrl: './view-business.component.html',
  styleUrls: ['./view-business.component.css'],
})
export class ViewBusinessComponent implements OnInit {
  Obj: BusinessData = new BusinessData();
  public allBusinessData: any;
  businessForm!: FormGroup;
  constructor(
    public dialog: MatDialog,
    private formBuilder: FormBuilder,
    private api: ApiService
  ) {}

  ngOnInit(): void {
    this.businessForm = this.formBuilder.group({
      ID: [''],
      Consumer_ID: [''],
      Business_Category: [''],
      Business_Type: [''],
      Business_Turnover: [''],
      Capital_Invested: [''],
      Total_Employees: [''],
      Business_Value: [''],
      Business_Age: [''],
    });
    this.getAllBusinessData();
  }

  createConsumer() {
    this.Obj.ID = this.businessForm.value.ID;
    this.Obj.Consumer_ID = this.businessForm.value.Consumer_ID;
    this.Obj.Business_Category = this.businessForm.value.Business_Category;
    this.Obj.Business_Type = this.businessForm.value.Business_Type;
    this.Obj.Business_Turnover = this.businessForm.value.Business_Turnover;
    this.Obj.Capital_Invested = this.businessForm.value.Capital_Invested;
    this.Obj.Total_Employees = this.businessForm.value.Total_Employees;
    this.Obj.Business_Value = this.businessForm.value.Business_Value;
    this.Obj.Business_Age = this.businessForm.value.Business_Age;

    this.api.postCreateBusiness(this.Obj).subscribe(
      (res) => {
        console.log(res);
        alert('Business Created Successfully!!');
        let ref = document.getElementById('clear');
        this.businessForm.reset();
      },
      (err) => {
        alert('Something went wrong');
      }
    );
  }

  getAllBusinessData() {
    let tokenStr = localStorage.getItem('token');
    let tokenStr1 = 'Bearer ' + tokenStr;

    const headers = new HttpHeaders().set('Authorization', tokenStr1);
    // this.api.getBusiness(headers).subscribe((res) => {
    //   let data = JSON.parse(res);

    //   console.log('Result' + data);
    //   // this.allBusinessData = res;
    // });

    this.api
      .getBusiness(headers)
      .toPromise()
      .then((res) => {
        let data = JSON.parse(res);
        this.allBusinessData = data;
        console.log('Promise data: ', this.allBusinessData);
      })
      .catch((err) => {
        console.log('Error: ', err);
      });
  }

  onViewBusiness(id: any) {
    console.log('view business is clicked with id:', id);
    let index = this.allBusinessData.findIndex((d: any) => d.id === id);
    console.log('index', index);

    const dialogRef = this.dialog.open(ViewBusinessDialogComponent, {
      data: this.allBusinessData[index].business,
    });
    dialogRef.afterClosed().subscribe((result) => {
      console.log(`Dialog result: ${result}`);
    });
  }
}
// dialog component reference
// @Component({
//   selector: 'vi',
//   templateUrl: ' view-business-dialog.component.html',
// })
// export class ViewBusinessDialogComponent {}
