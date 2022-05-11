import { Component, Input, OnInit } from '@angular/core';
import { Trail } from 'src/app/contracts/models';

@Component({
  selector: 'trail-item',
  templateUrl: './trail-item.component.html',
  styleUrls: ['./trail-item.component.css'],
})
export class TrailItemComponent implements OnInit {
  @Input('trail') public trail?: Trail;

  public get queryParams() {
    return {
      trailId: this.trail?.id,
    };
  }

  constructor() {}

  ngOnInit(): void {}
}
