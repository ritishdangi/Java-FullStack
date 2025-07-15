import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { NavbarComponent } from '../navbar/navbar.component';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-mobile-list',
  standalone: true,
  imports: [CommonModule,NavbarComponent],
  templateUrl: './mobile-list.component.html',
  styleUrls: ['./mobile-list.component.css'],
})
export class MobileListComponent {
  Allphones = [
    {
      brand: 'iPhone',
      name: 'Apple iPhone 16 (Black, 256 GB)',
      image:
        'https://rukminim2.flixcart.com/image/312/312/xif0q/mobile/f/y/e/-original-imah4jykc3knhq3b.jpeg?q=70',
      description: [
        '256 GB ROM',
        '16.0 cm (6.3 inch) Super Retina XDR Display',
        '48MP + 12MP Rear | 12MP Front Camera',
        'A18 Pro Chip, 6-Core Processor',
        '1 year warranty for phone and in-box accessories',
      ],
      amount:'₹69,999',
      off:'₹79,900',
      roff:'12% off',
      delivery:'Free delivery',
      img:'https://static-assets-web.flixcart.com/fk-p-linchpin-web/fk-cp-zion/img/fa_9e47c1.png',
    },
    {
      brand: 'iPhone',
      name: 'Apple iPhone 16 (Pink, 128 GB)',
      image:
        'https://rukminim2.flixcart.com/image/312/312/xif0q/mobile/o/8/z/-original-imah4jykj39bgzsh.jpeg?q=70',
      description: [
        '128 GB ROM',
        '15.49 cm (6.1 inch) Super Retina XDR Display',
        '48MP + 12MP | 12MP Front Camera',
        'A18 Chip, 6 Core Processor Processor',
        '1 year warranty for phone and 1 year warranty for in Box Accessories.',
      ],
      amount:'₹69,999',
      off:'₹79,900',
      roff:'12% off',
      delivery:'Free delivery',
      img:'https://static-assets-web.flixcart.com/fk-p-linchpin-web/fk-cp-zion/img/fa_9e47c1.png',
    },
    {
      brand: 'iPhone',
      name: 'Apple iPhone 16 (Ultramarine, 256 GB)',
      image:
        'https://rukminim2.flixcart.com/image/312/312/xif0q/mobile/f/o/1/-original-imah4jykr84cbhgc.jpeg?q=70',
      description: [
        '128 GB ROM',
        '15.49 cm (6.1 inch) Super Retina XDR Display',
        '48MP + 12MP | 12MP Front Camera',
        'A18 Chip, 6 Core Processor Processor',
        '1 year warranty for phone and 1 year warranty for in Box Accessories.',
      ],
      amount:'₹79,999',
      off:'₹89,900',
      roff:'11% off',
      delivery:'Free delivery',
      img:'https://static-assets-web.flixcart.com/fk-p-linchpin-web/fk-cp-zion/img/fa_9e47c1.png',
    },
    {
      brand: 'iPhone',
      name: 'Apple iPhone 16 Plus (Teal, 512 GB)',
      image:
        'https://rukminim2.flixcart.com/image/312/312/xif0q/mobile/t/8/p/-original-imah4jykf9e4a244.jpeg?q=70',
      description: [
        '512 GB ROM',
        '17.02 cm (6.7 inch) Super Retina XDR Display',
        '48MP + 12MP | 12MP Front Camera',
        'A18 Chip, 6 Core Processor Processor',
        '1 year warranty for phone and 1 year warranty for in Box Accessories.',
      ],
      amount:'₹1,09,999',
      off:'₹1,19,900',
      roff:'8% off',
      delivery:'Free delivery',
      img:'https://static-assets-web.flixcart.com/fk-p-linchpin-web/fk-cp-zion/img/fa_9e47c1.png',
    },
    // vivo phones
    {
    brand: 'Vivo',
      name: 'vivo T3 Ultra (Lunar Gray, 128 GB)',
      image:
        'https://rukminim2.flixcart.com/image/312/312/xif0q/mobile/s/a/s/-original-imah4hnh4z52kqqc.jpeg?q=70',
      description: [
        '8 GB RAM | 128 GB ROM',
        '17.22 cm (6.78 inch) Display',
        '50MP + 8MP | 50MP Front Camera',
        '5500 mAh Battery',
        'Dimensity 9200+ Processor',
        '1 Year Warranty on Handset and 6 Months Warranty on Accessories',
      ],
      amount:'₹27,999',
      off:'₹35,999',
      roff:'22% off',
      delivery:'Free delivery',
      img:'https://static-assets-web.flixcart.com/fk-p-linchpin-web/fk-cp-zion/img/fa_9e47c1.png',
    },
    {
      brand: 'Vivo',
        name: 'vivo T3 Ultra (Frost Green, 256 GB)',
        image:
        'https://rukminim2.flixcart.com/image/312/312/xif0q/mobile/l/6/x/t3-ultra-v2426-vivo-original-imah4hnfcx6hhhb8.jpeg?q=70',
        description: [
          '12 GB RAM | 256 GB ROM',
          '17.22 cm (6.78 inch) Display',
          '50MP + 8MP | 50MP Front Camera',
          '5500 mAh Battery',
          'Dimensity 9200+ Processor',
          '1 Year Warranty on Handset and 6 Months Warranty on Accessories',
        ],
        amount:'₹31,999',
        off:'₹39,999',
        roff:'20% off',
        delivery:'Free delivery',
        img:'https://static-assets-web.flixcart.com/fk-p-linchpin-web/fk-cp-zion/img/fa_9e47c1.png',
      },
      {
        brand: 'Vivo',
          name: 'vivo T3 Ultra (Frost Green, 256 GB)',
          image:
            'https://rukminim2.flixcart.com/image/312/312/xif0q/mobile/l/6/x/t3-ultra-v2426-vivo-original-imah4hnfcx6hhhb8.jpeg?q=70',
          description: [
            '8 GB RAM | 256 GB ROM',
            '17.22 cm (6.78 inch) Display',
            '50MP + 8MP | 50MP Front Camera',
            '5500 mAh Battery',
            'Dimensity 9200+ Processor',
            '1 Year Warranty on Handset and 6 Months Warranty on Accessories',
          ],
          amount:'₹29,999',
          off:'₹37,999',
          roff:'21% off',
          delivery:'Free delivery',
          img:'https://static-assets-web.flixcart.com/fk-p-linchpin-web/fk-cp-zion/img/fa_9e47c1.png',
        },
        {
          brand: 'Vivo',
            name: 'vivo T3 Ultra (Lunar Gray, 256 GB)',
            image:
              'https://rukminim2.flixcart.com/image/312/312/xif0q/mobile/s/a/s/-original-imah4hnh4z52kqqc.jpeg?q=70',
            description: [
              '8 GB RAM | 256 GB ROM',
              '17.22 cm (6.78 inch) Display',
              '50MP + 8MP | 50MP Front Camera',
              '5500 mAh Battery',
              'Dimensity 9200+ Processor',
              '1 Year Warranty on Handset and 6 Months Warranty on Accessories',
            ],
            amount:'₹29,999',
            off:'₹37,999',
            roff:'21% off',
            delivery:'Free delivery',
            img:'https://static-assets-web.flixcart.com/fk-p-linchpin-web/fk-cp-zion/img/fa_9e47c1.png',
          },
          // motorola
          {
            brand: 'Motorola',
              name: 'Motorola Edge 50 Pro 5G with 125W Charger (Caneel Bay, 256 GB)',
              image:
                'https://rukminim2.flixcart.com/image/312/312/xif0q/mobile/p/o/i/-original-imah4kfuzzxz6tvn.jpeg?q=70',
              description: [
                '12 GB RAM | 256 GB ROM',
                '17.02 cm (6.7 inch) Display',
                '50MP + 13MP + 10MP | 50MP Front Camera',
                '4500 mAh Battery',
                '7 Gen 3 Mobile Platform Processor',
                '1 Year Warranty on Handset and 6 Months Warranty on Accessories',
              ],
              amount:'₹29,999',
              off:'₹41,999',
              roff:'28% off',
              delivery:'Free delivery',
              img:'https://static-assets-web.flixcart.com/fk-p-linchpin-web/fk-cp-zion/img/fa_9e47c1.png',
            },
            {
              brand: 'Motorola',
                name: 'Motorola Edge 50 Pro 5G with 125W Charger (Luxe Lavender, 256 GB)',
                image:
                  'https://rukminim2.flixcart.com/image/312/312/xif0q/mobile/g/i/n/-original-imagzhspjy5g8nh3.jpeg?q=70',
                description: [
                  '12 GB RAM | 256 GB ROM',
                  '17.02 cm (6.7 inch) Display',
                  '50MP + 13MP + 10MP | 50MP Front Camera',
                  '4500 mAh Battery',
                  '7 Gen 3 Mobile Platform Processor',
                  '1 Year Warranty on Handset and 6 Months Warranty on Accessories',
                ],
                amount:'₹29,999',
                off:'₹41,999',
                roff:'28% off',
                delivery:'Free delivery',
                img:'https://static-assets-web.flixcart.com/fk-p-linchpin-web/fk-cp-zion/img/fa_9e47c1.png',
              },
              {
                brand: 'Motorola',
                  name: 'Motorola Edge 50 Pro 5G with 125W Charger (Black Beauty, 256 GB)',
                  image:
                    'https://rukminim2.flixcart.com/image/312/312/xif0q/mobile/e/i/v/-original-imagzhspm6zvfaeh.jpeg?q=70',
                  description: [
                    '12 GB RAM | 256 GB ROM',
                    '17.02 cm (6.7 inch) Display',
                    '50MP + 13MP + 10MP | 50MP Front Camera',
                    '4500 mAh Battery',
                    '7 Gen 3 Mobile Platform Processor',
                    '1 Year Warranty on Handset and 6 Months Warranty on Accessories',
                  ],
                  amount:'₹29,999',
                  off:'₹41,999',
                  roff:'28% off',
                  delivery:'Free delivery',
                  img:'https://static-assets-web.flixcart.com/fk-p-linchpin-web/fk-cp-zion/img/fa_9e47c1.png',
                },
                {
                  brand: 'Motorola',
                    name: 'Motorola Edge 50 Pro 5G with 125W Charger (Vanilla Cream, 256 GB)',
                    image:
                      'https://rukminim2.flixcart.com/image/312/312/xif0q/mobile/8/q/r/-original-imah2hnztmkzfyjk.jpeg?q=70',
                    description: [
                      '12 GB RAM | 256 GB ROM',
                      '17.02 cm (6.7 inch) Display',
                      '50MP + 13MP + 10MP | 50MP Front Camera',
                      '4500 mAh Battery',
                      '7 Gen 3 Mobile Platform Processor',
                      '1 Year Warranty on Handset and 6 Months Warranty on Accessories',
                    ],
                    amount:'₹29,999',
                    off:'₹41,999',
                    roff:'28% off',
                    delivery:'Free delivery',
                    img:'https://static-assets-web.flixcart.com/fk-p-linchpin-web/fk-cp-zion/img/fa_9e47c1.png',
                  },
  ];
  constructor(private route:ActivatedRoute){}

  phones : any[] = [];

  ngOnInit(){
    const brand = this.route.snapshot.paramMap.get('brand');
    if(brand){
      // this.phones = this.Allphones.filter((p) => p.brand === brand.toLowerCase());
      this.phones = this.Allphones.filter((p) => p.brand?.toLowerCase() === brand?.toLowerCase());

    }
  }
}
