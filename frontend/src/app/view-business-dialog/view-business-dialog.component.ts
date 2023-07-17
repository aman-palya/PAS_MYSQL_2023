import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-view-business-dialog',
  templateUrl: './view-business-dialog.component.html',
  styleUrls: ['./view-business-dialog.component.css'],
})
export class ViewBusinessDialogComponent implements OnInit {
  public businessData: any;
  constructor(@Inject(MAT_DIALOG_DATA) public data: any) {
    console.log('data in cons: ', this.data);
    this.businessData = data;
  }

  ngOnInit(): void {
    console.log('data in modal: ', this.businessData);
  }
}
